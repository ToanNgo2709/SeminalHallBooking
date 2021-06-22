package com.toanngo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Component
@Service("crunchifyEmail")
public class CrunchifyEmailAPI {

//	@Autowired
//	private MailSender crunchifymail; // MailSender interface defines a strategy
//										// for sending simple mails
// 
//	public void crunchifyReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
// 
//		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
//		crunchifyMsg.setFrom(fromAddress);
//		crunchifyMsg.setTo(toAddress);
//		crunchifyMsg.setSubject(subject);
//		crunchifyMsg.setText(msgBody);
//		crunchifymail.send(crunchifyMsg);
//	}
}
