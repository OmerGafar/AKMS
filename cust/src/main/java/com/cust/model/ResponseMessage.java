package com.cust.model;

public class ResponseMessage {
	private String title;
	private String body;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	 public String toString(){
		return "{\"title\":\""+title+"\",\"body\":\""+body+"\"}";
	}

}
