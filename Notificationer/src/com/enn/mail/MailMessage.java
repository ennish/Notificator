package com.enn.mail;

import java.util.List;

import com.enn.messageUtil.SmtpSender;
import com.enn.quartz.jobs.CommonMessage;

public class MailMessage extends CommonMessage {

	private String content;

	private List<String> receiver;

	private SmtpSender sender = null;

	public MailMessage(List<String> receiver, String content) {
		super(receiver, content);
		this.content = content;
		this.sender = new SmtpSender(content);
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
