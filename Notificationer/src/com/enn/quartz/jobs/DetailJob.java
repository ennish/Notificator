package com.enn.quartz.jobs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.enn.FileMessager.MessageWriter;

public class DetailJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		MessageWriter writer = new MessageWriter();
		String filename = writer.writeNewFile(sdf.format(cal.getTime())+"---"+this.getClass().getName());
		System.out.println(filename);
	}
}