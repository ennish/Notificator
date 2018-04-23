package com.enn.notifier.message;

import java.util.List;

import com.enn.notifier.Receiver;

public class SMSMessage implements MessageInterface {
	private Message msg;

	public SMSMessage(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessageText() {
		String text = "如您未订制相关服务，请忽略该条短信" + msg.getMsgBody();
		return text;
	}

	@Override
	public List<Receiver> getReceivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}

}
