package de.rayban.core.level.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Clock {

	long time = 0L;
	private final SimpleDateFormat sdf;

	public Clock() {
		sdf = new SimpleDateFormat("mm:ss");
	}


	public void reset() {

	}

	public void update(final int delta) {
		time += delta;
	}

	public String getTime() {
		return sdf.format(new Date(time));
	}

}
