package com.yousi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Countdown {
	public static void setCountTime(String sStartTime, String sEndTime,
			final TextView textView) {
		final long time;
		long startTime = formatterTime2(sStartTime);
		long endTime = formatterTime2(sEndTime);
		if (startTime < endTime) {
			time = endTime - startTime;
		} else {
			time = startTime - endTime;
		}
		CountDownTimer timer = new CountDownTimer(time, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				String time = formatterTime1(millisUntilFinished);
				textView.setText("剩余联系时间: " + time);
			}

			@Override
			public void onFinish() {
				textView.setText("已过期");
			}
		}.start();
	}

	public static String formatterTime1(long millTime) {
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT8"));
		String time = format.format(millTime);
		return time;
	}

	public static long formatterTime2(String time) {
		Date date = new Date(time);
		long millTime = date.getTime();
		return millTime;
	}
}
