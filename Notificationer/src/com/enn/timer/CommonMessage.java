package com.enn.timer;

import java.util.List;

public abstract class CommonMessage {

	private List<String> receiver;

	private String messageBody;

	public CommonMessage(List<String> receiver, String text) {
		super();
		this.receiver = receiver;
		this.messageBody = text;
	}

	public List<String> getReceiver() {
		return receiver;
	}

	public void setReceiver(List<String> receiver) {
		this.receiver = receiver;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public abstract String getMessageBody();

	public abstract int messageSend(List<String> receivre, String messageBody);
}
