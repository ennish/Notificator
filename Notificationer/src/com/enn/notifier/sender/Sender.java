package com.enn.notifier.sender;

import com.enn.notifier.message.Message;

public abstract class Sender {
	
	public abstract String send(Message message);
	 
}
