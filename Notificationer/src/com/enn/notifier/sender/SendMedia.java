package com.enn.notifier.sender;

public enum SendMedia {
	PURE(11), SMS(12), EMAIL(13);

	private int media;

	private SendMedia(int media) {
		this.media = media;
	}
}
