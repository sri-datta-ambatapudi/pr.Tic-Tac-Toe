package com.Coding.Web.Login;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "signup")
public class Login {

   @Id
   @JsonProperty("email")
public String email;
   
  @JsonProperty("password")
   	public String password;

}
