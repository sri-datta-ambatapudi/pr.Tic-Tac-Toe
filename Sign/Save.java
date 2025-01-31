package com.Coding.Web.Sign;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Coding.Web.Email.Email;
import com.Coding.Web.Signup.Signup;


@Repository
public interface Save extends CrudRepository<Signup, Long>
{
	 
	    Signup findByPassword(String password); 
	    Signup findByEmail(String email);

}
