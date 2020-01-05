package com.kmp.mailws.application.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmp.mailws.domain.entity.SendMailRequest;
import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;

@Component
public class SendGridClient {
	
	@Autowired
	private Environment environment;
	
	public Response sendEmail(SendMailRequest sendGridRequest) {
		Client client = new Client();
		Request request = new Request();
		Response response= null;
		
		request.setBaseUri(environment.getProperty("sendgrid.baseuri"));
		request.addHeader("Authorization", "Bearer " + environment.getProperty("sendgrid.apiKey"));
		
		request.setMethod(Method.POST);
		request.setEndpoint(environment.getProperty("sendgrid.endpoint"));
		ObjectMapper obj = new ObjectMapper();
		try {
			request.setBody(obj.writeValueAsString(sendGridRequest));
			response = client.api(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
