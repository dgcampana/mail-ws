package com.kmp.mailws.domain.entity;
import java.util.List;
import java.util.Map;

public class Personalization {
	private List<Mail> to;
	private List<Mail> cc;
	private Map<String, Object> dynamic_template_data;
	
	public List<Mail> getTo() {
		return to;
	}
	public void setTo(List<Mail> to) {
		this.to = to;
	}
	public List<Mail> getCc() {
		return cc;
	}
	public void setCc(List<Mail> cc) {
		this.cc = cc;
	}
	public Map<String, Object> getDynamic_template_data() {
		return dynamic_template_data;
	}
	public void setDynamic_template_data(Map<String, Object> dynamic_template_data) {
		this.dynamic_template_data = dynamic_template_data;
	}
	
}
