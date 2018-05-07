package com.enn.notify;

import java.util.TimerTask;

import com.enn.notifier.sender.MailSender;
import com.enn.notifier.message.MailMessage;

public class MailTask extends TimerTask {

	private MailSender sender;

	private MailMessage message;

	@Override
	public void run() {
		
	}

}
