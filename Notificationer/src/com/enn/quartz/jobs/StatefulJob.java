package com.enn.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class StatefulJob implements Job {

	public static final String NAME = "COUNTER";

	public static int count = 0;

	public StatefulJob() {
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if (context.get(this.NAME) != null) {
			context.put(this.NAME, count);
		} else {
			context.put(NAME, count++);
		}
		System.out.println("context data map:"+context.get(this.NAME));
		System.out.println("----jobKey:" + context.getJobDetail().getKey() + "----jobDataMap:"
				+ context.getJobDetail().getJobDataMap().getInt(this.NAME));
		context.getJobDetail().getJobDataMap().put(this.NAME, count);
	}
}
