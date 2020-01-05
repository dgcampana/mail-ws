package com.kmp.mailws.domain.dto;

import lombok.Data;

@Data
public class ReqUserActivation {
	private String sentTo;
	private String name;
	private String urlActivate;
}
