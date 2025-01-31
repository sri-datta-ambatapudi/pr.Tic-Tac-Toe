package com.Coding.Web.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
public class Email {
	
		@Autowired
    	private JavaMailSender jms;
 
		@Value("${spring.mail.username}")
		private String fromid;
		
		
		
    	public void mailMethod(String to,String body,String subjext )
    	{
    		SimpleMailMessage sm=new SimpleMailMessage();
    		
    		sm.setFrom(fromid);
    		sm.setTo(to);
    		sm.setText(body);
    		sm.setSubject(subjext);
    	
    		jms.send(sm);
    		
    	}
 
	

}
