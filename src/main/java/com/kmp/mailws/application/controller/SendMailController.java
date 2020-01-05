package com.kmp.mailws.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmp.mailws.domain.dto.ReqUserActivation;
import com.kmp.mailws.domain.service.SendMailService;
import com.sendgrid.Response;

@RestController
@RequestMapping("mail")
public class SendMailController {
	
	@Autowired
	private SendMailService sendEmailService;
	
	
	@PostMapping(path = "/user-activation")
	public ResponseEntity<Response> sendMailuserActivation(@RequestBody ReqUserActivation req) {
		Response response = sendEmailService.sendEmail(req);
		HttpStatus httpStatus= HttpStatus.valueOf(response.getStatusCode());
		
		return new  ResponseEntity<>(response, httpStatus);
	}
}
