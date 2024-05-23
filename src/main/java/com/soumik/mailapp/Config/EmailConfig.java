package com.soumik.mailapp.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {
    
    @Value("${email.to}")
    private String toEmail;
    
    @Value("${email.subject}")
    private String subject;
    
    @Value("${email.body}")
    private String body;

    public String getToEmail() {
        return toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
