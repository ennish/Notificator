package com.enn.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MessageJobWithParams implements Job {

	private String param1 ="PARAM:";

	public MessageJobWithParams(String param1) {
		this.param1 = param1;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("*********************"+param1+"**********************");
	}
}
