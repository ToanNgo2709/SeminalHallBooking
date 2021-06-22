package com.toanngo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.toanngo.app.service.CrunchifyEmailAPI;

@SpringBootApplication
public class SeminalHallBookingApplication {

	public static void main(String[] args) {
		
//		String crunchifyConfFile = "crunchify-bean.xml";
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
// 
//		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
//		CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
//		String toAddr = "ngotoanlibra@gmail.com";
//		String fromAddr = "toanngongo97@gmail.com";
// 
//		// email subject
//		String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";
// 
//		// email body
//		String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
//		crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
		
		SpringApplication.run(SeminalHallBookingApplication.class, args);
	}

}
