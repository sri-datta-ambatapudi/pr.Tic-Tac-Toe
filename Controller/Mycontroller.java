package com.Coding.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Coding.Web.Email.Email;
import com.Coding.Web.Login.Login;
import com.Coding.Web.Sign.Save;
import com.Coding.Web.Signup.Signup;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class Mycontroller
{
	@Autowired
	private Save save;
	
	@Autowired
	private Email email;
	
	
	
	@PostMapping("/post")
	public String  save(@RequestBody Signup signup ) 
	{
		String subj1="Hey, future legend! 🤩\r\n";
		String body1= signup.getUsername()+"\n"+"\n"+"You + Us = Amazing Things! Let’s Get Started! 🌟"+"\n"+
		"You’re SO close! Just click below to finalize your sign-up and you’ll be all set to dive in. 🌊\r\n";
		
				
		Object obj=save.save(signup);
		
		email.mailMethod(signup.getEmail(), body1, subj1);
		return "Sucess";
	}
	
	
	@PostMapping("/login")
	 public ResponseEntity<String> login(@RequestBody Login login)
		{
			Signup userbyemail=save.findByEmail(login.email);
			
			String body="YOOOO "+userbyemail.getUsername()+"\n"+"Congrats, you’re officially cooler than cool. Welcome to the squad of absolute GOATS. 🐐";
			String subj=" YOLO, Let’s Do This! 🎉";
			
			if (userbyemail!= null && userbyemail.getPassword().equals(login.password)) 
			{
				email.mailMethod(userbyemail.getEmail(), body, subj);
	            return ResponseEntity.ok("Login successful");
	            
	            
	        }
			else 
	        {
	            return ResponseEntity.ok("Invalid credentials");
	        }		
    }
	
	
//			@GetMapping("/mail")
//			public String sendMail() 
//			{
//				String body="heloa,we are  welcomeing to our parth thanks for chosing us";
//				String subj=" thanks for login";
//				
//				email.mailMethod(loginService.email, body, subj);
//				
//				return"sucess";
//			}
	
	// create user  
	// delete  user
	// update name and  details 
	
}
