package com.enn.notifier.test;

import com.enn.notifier.message.MailMessage;
import com.enn.notifier.message.Message;
import com.enn.notifier.sender.MailSender;
import com.enn.notifier.sender.Sender;
import com.enn.notify.SendTask;

public class TaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sender sender = new MailSender();
		Message message = new MailMessage();
		SendTask task = new SendTask();
		
	}

}
