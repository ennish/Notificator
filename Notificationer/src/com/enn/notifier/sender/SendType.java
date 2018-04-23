package com.enn.notifier.sender;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SendType {

	private SendMedia media;
	private SendFreq freq;

	private Date time;// time to send

	private List<Date> timeList;// times to send

	private long period;// time period

	public SendType(Date time, SendMedia media) {
		super();
		this.freq = SendFreq.ONCE;
		this.media = media;
		this.time = time;
	}

	public SendType(Date time, long period, SendMedia media) {
		super();
		this.freq = SendFreq.SCHEDULED;
		this.media = media;
		this.time = time;
		this.period = period;
	}

	public SendType(List<Date> timeList, SendMedia media) {
		super();
		this.freq = SendFreq.MULT;
		this.media = media;
		this.timeList = timeList;
	}

	public long getTimeInterval() {
		Calendar cal = Calendar.getInstance();
		long interval = time.getTime() - cal.getTimeInMillis();
		return interval > 0 ? interval : 0;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public List<Date> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Date> timeList) {
		this.timeList = timeList;
	}

	public SendMedia getMedia() {
		return media;
	}

	public SendFreq getFreq() {
		return freq;
	}

}
