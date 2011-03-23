package de.rayban.log;

public interface MessageWorker {
	public static final int debug = 0;
	public static final int info = 1;
	public static final int note = 2;
	public static final int warn = 3;
	public static final int error = 4;

	public void doMessage(final Message msg, final int logLevel);
}
