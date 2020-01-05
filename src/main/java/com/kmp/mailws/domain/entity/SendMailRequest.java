package com.kmp.mailws.domain.entity;

import java.util.List;

public class SendMailRequest {
	private List<Personalization> personalizations;
	private Mail from;
	private String subject;
	private List<Content> content;
	private List<Attachment> attachments;
	private List<String> categories;
	private String template_id;
	
	public List<Personalization> getPersonalizations() {
		return personalizations;
	}
	public void setPersonalizations(List<Personalization> personalizations) {
		this.personalizations = personalizations;
	}
	public Mail getFrom() {
		return from;
	}
	public void setFrom(Mail from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
}
