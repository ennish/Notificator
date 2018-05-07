package com.enn.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.enn.mail.MailMessage;
import com.enn.quartz.jobs.CommonMessage;
import com.enn.quartz.jobs.SMSMessage;

public class TimerAccess {

	public static final String MSG_TYPE_MAIL = "MAIL";

	public static final String MSG_TYPE_SMS = "SMS";

	private Log log = LogFactory.getLog(this.getClass());

	private static Timer timer = null;

	public static void init() {
		System.out.println("initializing...");
		if (timer == null)
			timer = new Timer();
		// 暂未考虑多线程
	}

	/**
	 * 指定一次发送任务
	 * 
	 * @param mtType
	 *            消息类型 mail sms
	 * @param receivers
	 *            接收方
	 * @param content
	 *            短信内容
	 * @param delay
	 *            延迟时间 单位 ms
	 */
	public static void addOnceTask(String mtType, List<String> receivers, String content, Long delay) {
		CommonMessage message = null;
		if (mtType == null) {
			System.out.println("mtType must be specified!");
			return;
		}
		if (MSG_TYPE_MAIL.equals(mtType.toUpperCase())) {
			message = new MailMessage(receivers, content);
		} else if (MSG_TYPE_SMS.equals(mtType.toUpperCase())) {
			message = new SMSMessage(receivers, content);
		}
		if(delay == null || delay < 0) {
			delay = 0L;
		}
		timer.schedule(new MessageTask(message), delay);
	}

	public static void main(String[] args) {
		// Timer timer = new Timer();
		// List<String> receiver = new ArrayList<String>();
		// receiver.add("2396191290@qq.com");
		// String content = "test !";
		// CommonMessage message = new MailMessage(receiver, content);
		//
		// // 单次
		// timer.schedule(new MessageTask(message), 1000);
		//
		// // 单次定时
		// Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.SECOND, 10);
		// timer.schedule(new MessageTask(message), cal.getTime());
		//
		// // 循环定时
		// timer.scheduleAtFixedRate(new MessageTask(message), 100, 3600 * 24);
		// Calendar cal2 = Calendar.getInstance();
		// timer.scheduleAtFixedRate(new MessageTask(message), cal2.getTime(), 3600 * 24
		// * 7);
		init();
		System.out.println("Usage: java -jar TimerMessage.jar -t message type -r receivers[split by ','] -c content [-d delay]");
		int optind;
		String mtype = "";
		List<String> receiver = null ;
		String content = "";
		Long delay = null;
		for (optind = 0; optind < args.length; optind++) {
			if ("-T".equals(args[optind].toUpperCase())) {
				mtype = args[++optind].toUpperCase();
				if(MSG_TYPE_MAIL.equals(mtype)||MSG_TYPE_SMS.equals(mtype)) {
				}else {
					return;
				}
			}
			if ("-R".equals(args[optind].toUpperCase())) {
				//TODO 根据type 验证收件人格式是否正确
				
				String tmp_param = args[++optind];
				if(tmp_param==null) {
					return ;
				}
				receiver = new ArrayList<String>();
				String[] tmp_rs = tmp_param.split(",");
				for(int i = 0;i<tmp_rs.length ;i++) {
					receiver.add(tmp_rs[i]);
				}
			}
			if ("-C".equals(args[optind].toUpperCase())) {
				content = args[++optind];
			}
			if ("-D".equals(args[optind].toUpperCase())) {
				String tmp_long = args[optind];
				if(tmp_long != null) {
					delay = Long.parseLong(tmp_long);
				}
			}
		}
		addOnceTask(content, receiver, content, delay);
	}
}
