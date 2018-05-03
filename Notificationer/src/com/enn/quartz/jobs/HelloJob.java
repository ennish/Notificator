package com.enn.quartz.jobs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
		System.out.println(sdf.format(cal.getTime()) + "--- Hellow Job");
	}

}
