package de.rayban.log;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	private static final Map<Class<?>, Logger> loggers = new HashMap<Class<?>, Logger>();

	private final int loggingInterval;

	private final Map<String, Long> notes = new HashMap<String, Long>();

	private final Class<?> loggerClass;

	private Logger(final Class<?> loggerClass){
		loggingInterval = 1000; // 1 Sekunde
		this.loggerClass = loggerClass;
	}

	public void note(final String msg){
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

	public void writeNote(final String msg){
		System.out.println("NOTE ["+loggerClass.getCanonicalName()+"]: " + msg);
	}

	public static Logger instance(final Class<?> clazz){
		if(loggers.containsKey(clazz)){
			return loggers.get(clazz);
		}

		loggers.put(clazz, new Logger(clazz));
		return loggers.get(clazz);
	}
}
