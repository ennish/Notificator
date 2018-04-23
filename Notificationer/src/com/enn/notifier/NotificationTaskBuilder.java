package com.enn.notifier;

import java.util.Timer;

import com.enn.notifier.message.MessageInterface;

/**
 * 
 * @author hacker
 *
 */
public class NotificationTaskBuilder {

	Timer timer = new Timer();

	public void addTask(MessageInterface message, Long time, Long period) {
		NotificationTask task = new NotificationTask(message, period);
		switch (task.getFreq()) {
		default:
			break;
		case ONCE:
			timer.schedule(task, time);
			break;
		case SCHEDULED:
			timer.schedule(task, time, period);
			break;
		}

	}

}
