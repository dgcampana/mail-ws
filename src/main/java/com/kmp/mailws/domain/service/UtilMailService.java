package com.kmp.mailws.domain.service;

import java.util.List;

import com.kmp.mailws.domain.entity.Mail;

public interface UtilMailService {
	
	Mail getMailFrom();
	List<Mail> getMailTo(String name, String mail);

}
