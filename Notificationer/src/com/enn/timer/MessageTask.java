package com.enn.timer;

import java.util.TimerTask;

import com.enn.quartz.jobs.CommonMessage;

public class MessageTask extends TimerTask {

	private CommonMessage message;

	public MessageTask(CommonMessage message) {
		this.message = message;
	}

	@Override
	public void run() {
		message.messageSend(message.getReceiver(), message.getMessageBody());
	}
}
