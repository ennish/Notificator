package com.enn.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.simpl.PropertySettingJobFactory;

import com.enn.quartz.jobs.MessageJobWithParams;

public class MessageJobTest {

	public void JobFactoryTest() {
		PropertySettingJobFactory fac = new PropertySettingJobFactory();
	}
	
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		MessageJobWithParams job2 = new MessageJobWithParams("PARAM2");
		// 指定消息类型
		JobDetail job = newJob(job2.getClass()).withDescription("hellow job").withIdentity("job1", "group1").build();

		// 配置具体的发送策略
		CronTrigger trigger = (CronTrigger) newTrigger().withDescription("stateful job")
				.withSchedule(cronSchedule("0/5 * * * * ?")).withIdentity("cronTrigger2", "group1").build();
		scheduler.scheduleJob(job,trigger);
		scheduler.start();
		
	}
}
