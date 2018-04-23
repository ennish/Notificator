package com.enn.notifier;

import java.util.Calendar;

import com.enn.notifier.message.MailMessage;
import com.enn.notifier.message.Message;

public class SendTest {
	public static void main(String[] args) {
		testTypeOnce();
	}

	public static void testTypeOnce() {
		NotificationTaskBuilder builder = new NotificationTaskBuilder();
		Receiver rec = new Receiver("tw", "15727644231", null);
		Message msg = new Message(":msg " + (char) ((int) ((Math.random() * 1000) % 26) + 97), rec);
		MailMessage mail = new MailMessage(msg);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		builder.addTask(mail, cal.getTimeInMillis(), 10000L);
	}
}
