package com.enn.notifier.message;

public abstract class Message {
	
	private String To = "";
	private String From = "";
	private String content = "";
	
	//每种消息都须返回消息体
	public abstract String getContent();

}
