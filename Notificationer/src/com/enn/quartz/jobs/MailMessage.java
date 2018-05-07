package com.enn.quartz.jobs;

import java.util.List;

import com.enn.messageUtil.SmtpSender;
import com.enn.quartz.jobs.CommonMessage;

public class MailMessage extends CommonMessage {

	private String text;

	private List<String> receiver;

	private SmtpSender sender = null;

	public MailMessage(List<String> receiver, String text) {
		super(receiver, text);
		this.text = text;
		this.sender = new SmtpSender(text);
	}

	@Override
	public String getMessageBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int messageSend(List<String> receivre, String messageBody) {
		// TODO Auto-generated method stub
		sender.send();
		return 0;
	}

}
