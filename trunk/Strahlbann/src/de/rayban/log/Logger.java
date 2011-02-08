package de.rayban.log;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	private static final Map<Class<?>, Logger> loggers = new HashMap<Class<?>, Logger>();

	private static final MessageWorker mw = new MessageWorkerImpl();

	private final Map<String, Long> notes = new HashMap<String, Long>();

	private final Class<?> loggerClass;

	private int loggingInterval;

	private int logLevel = MessageWorker.note;

	private Logger(final Class<?> loggerClass){
		loggingInterval = 1000; // 1 Sekunde
		this.loggerClass = loggerClass;
	}

	public void note(final String msg){
		if(logLevel > MessageWorker.note)
			return;

		if(notes.containsKey(msg) == false){
			writeNote(msg);
			notes.put(msg, System.currentTimeMillis());
		}

		final Long timeMillisOnLastCall = notes.get(msg);
		final Long now = System.currentTimeMillis();
		if(now - timeMillisOnLastCall > loggingInterval){
			writeNote(msg);
			notes.put(msg, now);
		}
	}

	private void writeNote(final String msg){
		mw.doMessage(new Message(msg, loggerClass), MessageWorker.note);
	}

	public static Logger instance(final Class<?> clazz){
		if(loggers.containsKey(clazz)){
			return loggers.get(clazz);
		}

		loggers.put(clazz, new Logger(clazz));
		return loggers.get(clazz);
	}

	public int getLoggingInterval() {
		return loggingInterval;
	}

	public void setLoggingInterval(final int loggingInterval) {
		this.loggingInterval = loggingInterval;
	}

	public int getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(final int logLevel) {
		this.logLevel = logLevel;
	}
}
