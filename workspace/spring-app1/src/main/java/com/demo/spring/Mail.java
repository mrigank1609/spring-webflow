package com.demo.spring;

import java.util.List;

public class Mail {
	private List<String> toAddress;
	private String fromAddress;
	private Message message;

	public List<String> getToAddress() {
		return toAddress;
	}

	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
