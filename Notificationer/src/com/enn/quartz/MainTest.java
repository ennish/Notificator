package com.enn.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.CronScheduleBuilder.cronSchedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.enn.quartz.jobs.DetailJob;
import com.enn.quartz.jobs.HelloJob;
import com.enn.quartz.jobs.StatefulJob;

public class MainTest {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:ss");

	/**
	 * simple scheduled task
	 * 
	 * @throws SchedulerException
	 * @throws InterruptedException
	 */
	public void run() throws SchedulerException, InterruptedException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();

		cal.add(Calendar.SECOND, 10);
		// Date runTime = evenMinuteDate(new Date());
		JobDetail job = newJob(DetailJob.class).withIdentity("job1", "group1").build();

		// Trigger the job to run on the next round minute
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(cal.getTime()).build();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		try {
			// wait 65 seconds to show job
			Thread.sleep(65L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}
		// shut down the scheduler
		scheduler.shutdown(true);
	}

	/**
	 * Quartz using Simple Triggers.
	 * 
	 * @throws SchedulerException
	 */
	public void simpleTriggerRun() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		cal.add(Calendar.SECOND, 5);

		Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
		// run once
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
		// repeat 10 times with 10s interval
		SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger1", "group1")
				.withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).startAt(startTime)
				.build();
		Date df = scheduler.scheduleJob(job, trigger);
		System.out.println(job.getKey() + " will run at:" + sdf.format(df) + " and repeat " + trigger.getRepeatCount()
				+ "times, every " + trigger.getRepeatInterval() / 1000 + " seconds");
		scheduler.start();
		try {
			Thread.sleep(100000L * 65L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduler.shutdown();
	}

	/**
	 * Quartz using Cron Triggers.
	 * 
	 * cron表达式 Seconds Minutes Hours DayofMonth Month DayofWeek
	 * 
	 * '*'表示范围内任何数
	 * 
	 * '-' 表示从某个数到某个数
	 * 
	 * ',' 表达一个列表值 a,b,c
	 * 
	 * 'x/y' 表达一个等步长序列，x为起始值，y为增量步长值。
	 * 
	 * L：该字符只在日期和星期字段中使用，代表“Last”的意思，但它在两个字段中意思不同。
	 * L在日期字段中，表示这个月份的最后一天，如一月的31号，非闰年二月的28号；如果L用在星期中，则表示星期六，等同于7。
	 * 但是，如果L出现在星期字段里，而且在前面有一个数值X，则表示“这个月的最后X天”，例如，6L表示该月的最后星期五；
	 * W：该字符只能出现在日期字段里，是对前导日期的修饰，表示离该日期最近的工作日。
	 * 例如15W表示离该月15号最近的工作日，如果该月15号是星期六，则匹配14号星期五；
	 * 如果15日是星期日，则匹配16号星期一；如果15号是星期二，那结果就是15号星期二。
	 * 但必须注意关联的匹配日期不能够跨月，如你指定1W，如果1号是星期六，结果匹配的是3号星期一，而非上个月最后的那天。
	 * W字符串只能指定单一日期，而不能指定日期范围；
	 * 
	 * @throws SchedulerException
	 */
	public void cronTriggerRun() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();

		JobDetail job = newJob(HelloJob.class).withDescription("hellow job").withIdentity("job1", "group1").build();
		CronTrigger trigger = (CronTrigger) newTrigger().withIdentity("cronTrigger1", "group1")
				.withSchedule(cronSchedule("0/20 * * * * ?")).build();

		Date df = scheduler.scheduleJob(job, trigger);

		System.out.println(job.getKey() + " will run at:" + trigger.getStartTime());

		scheduler.start();

		// scheduler.shutdown();
	}

	public void StateFulJobRun() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		CronTrigger trigger = (CronTrigger) newTrigger().withDescription("stateful job")
				.withSchedule(cronSchedule("0/5 * * * * ?")).withIdentity("cronTrigger2", "group1").build();
		JobDetail job = newJob(StatefulJob.class).withDescription("hellow job").withIdentity("job1", "group1").build();
		scheduler.scheduleJob(job,trigger);
		scheduler.start();
		// scheduler.shutdown();
	}

	/**
	 * 
	 * @param args
	 * @throws SchedulerException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		MainTest main = new MainTest();

		// main.run();

		// main.simpleTriggerRun();

		// main.cronTriggerRun();
		
		main.StateFulJobRun();
	}
}
