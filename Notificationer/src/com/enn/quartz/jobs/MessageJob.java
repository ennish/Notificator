package com.enn.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MessageJob implements Job {

	private CommonMessage message;

	public MessageJob(CommonMessage message) {
	}
 

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		message.messageSend(message.getReceiver(), message.getMessageBody());
	}

}
