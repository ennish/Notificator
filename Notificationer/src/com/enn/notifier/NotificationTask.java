package com.enn.notifier;

import java.util.TimerTask;

import com.enn.notifier.message.MessageInterface;
import com.enn.notifier.sender.SendFreq;
import com.enn.notifier.sender.Sender;

/**
 * 提醒任务类
 * 根据 提醒时间，提醒周期
 * ps 对于参数列表相同 而功能不同的情况如何解决？
 * 构造提醒任务
 * @author hacker
 *
 */
public class NotificationTask extends TimerTask {

	private MessageInterface msgInterface;
	private Long time;
	private Long period;
	private Sender sender;// 发送者
	private SendFreq freq;
	
	public SendFreq getFreq() {
		return freq;
	}

	public NotificationTask(MessageInterface msgInterface, Long time) {
		super();
		this.msgInterface = msgInterface;
		this.time = time;
		this.freq = SendFreq.ONCE;
	}
	
	public NotificationTask(MessageInterface message,Long time,Long period) {
		msgInterface = message;
		this.time = time;
		this.period = period;
		this.freq = SendFreq.SCHEDULED;
	}

	@Override
	public void run() {
		 
		sender.send(msgInterface);
	}
}
