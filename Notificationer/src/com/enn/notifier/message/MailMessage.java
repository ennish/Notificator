package com.enn.notifier.message;

import java.util.List;

import com.enn.notifier.Receiver;

public class MailMessage implements MessageInterface{
	
	private Message msg;

	public MailMessage(Message msg) {
		this.msg = msg;
	}
	@Override
	public String getMessageText() {
		String text = "<h1>Dear "+msg.getReceivers().getName()+"</h1>";
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
