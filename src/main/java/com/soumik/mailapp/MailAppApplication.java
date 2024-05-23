package com.soumik.mailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.soumik.mailapp.Config.EmailConfig;
import com.soumik.mailapp.Services.EmailSenderService;

@EnableScheduling
@SpringBootApplication
public class MailAppApplication {
	
	@Autowired
	private EmailSenderService senderService;
	
	@Autowired
	private EmailConfig emailConfig;

	public static void main(String[] args) {
		SpringApplication.run(MailAppApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		senderService.sendEmail(emailConfig.getToEmail(), emailConfig.getSubject(), emailConfig.getBody());
	}

}
