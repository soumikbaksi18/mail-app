package com.soumik.mailapp.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.soumik.mailapp.Config.EmailConfig;

@Service
@Component("customTaskScheduler")
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailConfig emailConfig;
	
	@Scheduled(fixedRate=5000)
	public void performEmailSending() {
		 sendEmail(emailConfig.getToEmail(), emailConfig.getSubject(), emailConfig.getBody());
    }
	
	
	public void sendEmail(String toEmail, String subject, String body) {
		
		SimpleMailMessage message =new SimpleMailMessage();
		message.setFrom("baksisoumik@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("Mail Sent Succesfully");
		
	}
	
	
}

