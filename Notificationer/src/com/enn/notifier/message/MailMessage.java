package com.enn.notifier.message;

public class MailMessage extends Message{
	private String content;
	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}

	public String getMailContent() {
		return "mail content:"+content;
	}
	
}
