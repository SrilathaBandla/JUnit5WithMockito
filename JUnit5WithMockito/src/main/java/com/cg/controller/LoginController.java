package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Login;
import com.cg.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	
	@PostMapping(value="/adminLogin",consumes="application/json")
	public ResponseEntity<Boolean> login(@RequestBody Login login){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.login(login));
	}
	
	
	@PostMapping(value="/addAdmin",consumes="application/json")
	public boolean register(@RequestBody Login reg) {
	//	System.out.println("Hello");
		return service.register(reg);
		
		}
	

}
