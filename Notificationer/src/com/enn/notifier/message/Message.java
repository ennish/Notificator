package com.enn.notifier.message;

import com.enn.notifier.Receiver;

/**
 * Message to notification,
 * include message content and message receivers
 * @author hacker
 *
 */
public class Message{
	
	private String msgBody;//message body
	private Receiver receivers;//message receivers
	
	public Message(String msgBody, Receiver receivers) {
		super();
		this.msgBody = msgBody;
		this.receivers = receivers;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public Receiver getReceivers() {
		return receivers;
	}

	public void setReceivers(Receiver receivers) {
		this.receivers = receivers;
	}
}
