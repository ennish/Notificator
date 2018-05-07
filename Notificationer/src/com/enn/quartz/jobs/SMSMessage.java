package com.enn.quartz.jobs;

import java.util.List;

public class SMSMessage extends CommonMessage {

	private String content;

	private List<String> receiver;

	public SMSMessage(List<String> receiver, String text) {
		super(receiver, text);
		this.receiver = receiver;
		this.content = text;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMessageBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int messageSend(List<String> receivre, String messageBody) {
		// TODO Auto-generated method stub
		return 0;
	}

}
