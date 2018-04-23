package com.enn.notifier.sender;

import com.enn.notifier.message.MessageInterface;

//使用该定时任务的外部方法应实现该接口
public interface Sender {
	
	void send(MessageInterface msgInterface);
}
