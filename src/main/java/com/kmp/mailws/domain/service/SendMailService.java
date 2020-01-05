package com.kmp.mailws.domain.service;


import com.kmp.mailws.domain.dto.ReqUserActivation;
import com.sendgrid.Response;

public interface SendMailService {

	Response sendEmail(ReqUserActivation req);
}
