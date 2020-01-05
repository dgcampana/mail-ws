package com.kmp.mailws.application.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.kmp.mailws.domain.entity.Mail;
import com.kmp.mailws.domain.service.UtilMailService;


@Service
public class UtilMailServiceImpl implements UtilMailService {
	
	@Autowired
	private Environment env;

	@Override
	public Mail getMailFrom() {
		Mail from= new Mail();
		from.setEmail(env.getProperty("send.from.mail"));
		from.setName(env.getProperty("send.from.name"));
		
		return from;
	}

	@Override
	public List<Mail> getMailTo(String name, String mail) {
		Mail to = new Mail();
		List<Mail> toList = new ArrayList<>();
		to.setEmail(mail);
		to.setName(name);
		toList.add(to);
		
		return toList;
	}
	
	

}
