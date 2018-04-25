package com.enn.notify;

import java.util.Date;
import java.util.Timer;

public class NotifyTaskBuilder {

	private Timer timer;
	private SendTask task;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//初始化task，timer
	public NotifyTaskBuilder() {
		
	}

	// 向timer中添加定时事件
	public void addTask(Date time) {
		timer.schedule(task,time.getTime());
	}

	// 向timer中添加重复事件
	public void addFixedRatedTask(Date time, Long period) {
		timer.schedule(task, time, period);
	}
}
