package com.rest.blog.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.blog.payloads.UserDto;
import com.rest.blog.services.EmailService;

import com.rest.blog.services.UserService;

@RestController
@RequestMapping("/newsletter")
public class EmailController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;


	@GetMapping("/{postId}")
	public ResponseEntity<HashMap<String,String>> sendEmail(@PathVariable int postId) {

		HashMap<String, String> hmap = new HashMap<>();
		ArrayList<String> newsletter = new ArrayList<>();
		hmap.put("Response", "Sent successfully");
		List<UserDto> users=	userService.getAllUsers();
		for(UserDto user : users){
			if(user.getNewsletter()==1) {
				newsletter.add(user.getEmail());
				System.out.println(user.getEmail());
			}
		}
		boolean status = emailService.sendSimpleMail(newsletter,postId);
		System.out.println(status);
		if (status) {
			return ResponseEntity.status(HttpStatus.OK).body(hmap);
		}
		hmap.put("Response", "Either token is missing or something went wrong.");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hmap);

	}
}