package com.enn.notifier.message;

public class SmsMessage extends Message {
	
	String to;//接收方
	String content;

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return "sms content";
	}
	
	public String getTo() {
		return to;
	}
	
	public String getSmsBody() {
		return "sms body:" + content;
	}
}
