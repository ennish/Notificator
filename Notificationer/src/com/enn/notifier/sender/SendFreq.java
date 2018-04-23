package com.enn.notifier.sender;

public enum SendFreq {
	ONCE(1), SCHEDULED(2), MULT(3);

	private int type;

	private SendFreq(int type) {
		this.type = type;
	}
}

