package com.enn.notifier.message;

import java.util.List;

import com.enn.notifier.Receiver;

public interface MessageInterface {

	Message getMessage();//获取消息对象
	
	String getMessageText();//获取格式化的消息内容
	
	List<Receiver> getReceivers();//获取消息接收人
	
}
