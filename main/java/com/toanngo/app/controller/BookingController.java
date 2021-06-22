package com.toanngo.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toanngo.app.SessionType;
import com.toanngo.app.model.Booking;
import com.toanngo.app.model.SeminarHall;
import com.toanngo.app.model.UserInfo;
import com.toanngo.app.service.BookingService;
import com.toanngo.app.service.HallService;
import com.toanngo.app.service.UserInfoService;

@Controller
public class BookingController {

	@Autowired
	UserInfoService userService;
	@Autowired
	HallService hallService;
	@Autowired
	BookingService bookingService;

	@RequestMapping(value = "/booking/book", method = RequestMethod.GET)
	public String showBookingForm(Model model) {
		Booking booking = new Booking();
		model.addAttribute("newBooking", booking);
		return "/ClientPage/booking_add";
	}

	// Get Active Hall when booking
	@ModelAttribute(name = "hallList")
	public List<SeminarHall> getActiveList() {
		return hallService.GetActive(true);
	}

	@RequestMapping(value = "/booking/add", method = RequestMethod.POST)
	public String addBooking(@ModelAttribute("newBooking") Booking booking, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");

		// Check if user Login
		if (id != null) {

			// Check if any booking in that time range
			UserInfo currentUser = userService.GetById(id);
			List<Booking> bookingList = bookingService.GetBookingListByDate(booking.getFromDate(), booking.getToDate(),
					booking.getHall().getId());
			booking.setUserInfo(currentUser);

			// If not, add it as a new booking
			if (bookingList.size() == 0) {
				bookingService.Create(booking);
				return "redirect:/";
			} else {
				switch (booking.getSession()) {
				case "morning":
					createBookingAfterCheck(bookingList, SessionType.MORNING, booking);
					break;
				case "afternoon":
					createBookingAfterCheck(bookingList, SessionType.AFTERNOON, booking);
					break;
				case "allday":
					System.out.println("Cannot add booking allday because already had booking in day ");
					return "redirect:/";
				}
			}
		} else {
			System.out.println("Please Login to Booking");
			return "redirect:/authen/login";
		}
		return "redirect:/";

	}

	// Set hall status to false when booking is all day
	public String checkBrandNewAllDayBooking(Booking booking) {
		if (booking.getSession().equals("allday")) {
			SeminarHall selectedHall = hallService.GetById(booking.getHall().getId());
			selectedHall.setActive(false);
			hallService.Update(selectedHall);
			System.out.println("Create Booking success all day");
			return "redirect:/";
		} else {
			System.out.println("Create Booking success");
			return "redirect:/";
		}
	}

	//Check if any booking with session type exist
	public Booking checkExistBookingBySession(List<Booking> bookingList, String sessionType) {
		for (Booking item : bookingList) {
			if (item.getSession().equals(sessionType)) {
				return item;			
			}
		}
		return null;
	}
	
	//after check exist, decide to create booking or not
	public void createBookingAfterCheck(List<Booking> bookingList, String sessionType, Booking booking) {
		
		if(checkExistBookingBySession(bookingList, sessionType) != null ) {
			System.out.println( sessionType + " already exist, try again");
		}else {
			bookingService.Create(booking);
			System.out.println("Create booking success");
		}
	}
	

	// Show Booking history By User
	@RequestMapping(value = "/booking/history", method = RequestMethod.GET)
	public String bookingHistory(Model model, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");
		if (id != null) {
			List<Booking> bookingList = bookingService.GetBookingByUserId(id);
			model.addAttribute("bookingList", bookingList);
			return "/ClientPage/booking_history";
		} else {
			System.out.println("Please login to see history");
			return "redirect:/authen/login";
		}
	}
	
	@RequestMapping(value = "/admin/booking_manage", method = RequestMethod.GET)
	public String bookingManage(Model model) {
		List<Booking> bookingList = bookingService.GetAll();
		model.addAttribute("bookingList", bookingList);
		return "/AdminPage/BookingManage";
	}
	
	@RequestMapping(value = "/admin/booking_approve/{id}")
	public String approveBooking(@PathVariable("id") int bookingId) {
		//approve for booking
		Booking selectedBooking = bookingService.GetById(bookingId);
		selectedBooking.setApproveStatus(true);
		bookingService.Update(selectedBooking);
		
		//change hall status when approve;
		SeminarHall selectedHall = selectedBooking.getHall();
		selectedHall.setActive(false);
		hallService.Update(selectedHall);
		return "redirect:/admin/booking_manage";		
	}
	
	@RequestMapping(value = "/admin/booking_deny/{id}")
	public String denyBooking(@PathVariable("id") int bookingId) {
		bookingService.Delete(bookingId);
		return "redirect:/admin/booking_manage";
	}

}
