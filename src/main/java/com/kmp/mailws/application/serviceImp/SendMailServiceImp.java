package com.kmp.mailws.application.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.kmp.mailws.application.client.SendGridClient;
import com.kmp.mailws.domain.dto.ReqUserActivation;
import com.kmp.mailws.domain.entity.Mail;
import com.kmp.mailws.domain.entity.Personalization;
import com.kmp.mailws.domain.entity.SendMailRequest;
import com.kmp.mailws.domain.service.SendMailService;
import com.kmp.mailws.domain.service.UtilMailService;
import com.sendgrid.Response;

@Service
public class SendMailServiceImp implements SendMailService{

	@Autowired
	private SendGridClient sendGridClient;
	@Autowired
	private Environment env;
	@Autowired 
	private UtilMailService utilMailService;	 
	
	@Override
	public Response sendEmail(ReqUserActivation req) {
		SendMailRequest sendgridReq = new SendMailRequest();
		Personalization personalization = new Personalization();
		// from
		Mail from = utilMailService.getMailFrom();
		sendgridReq.setFrom(from);
		
		// to
		List<Mail> to = utilMailService.getMailTo(req.getName(), req.getSentTo());
		personalization.setTo(to);
		
		// template
		String idTemplate = env.getProperty("sg.template.user-activation");
		sendgridReq.setTemplate_id(idTemplate);
		
		// dynamic data
		Map<String, Object> dynamicData = new HashMap<>();
		dynamicData.put("name", req.getName());
		dynamicData.put("url-activate", req.getUrlActivate());
		personalization.setDynamic_template_data(dynamicData);
		
		List<Personalization> toPersonalization = new ArrayList<>();
		toPersonalization.add(personalization);
		
		sendgridReq.setPersonalizations(toPersonalization);
		return sendGridClient.sendEmail(sendgridReq);
	}

}
