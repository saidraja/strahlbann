package de.rayban.log;

/**
 * Interne Repräsentation einer Nachricht des Logger Systems
 *
 * @author Daniel
 *
 */
public class Message {
	private String msg;

	private Class<?> loggingClass;

	public Message(final String msg, final Class<?> loggingClass) {
		super();
		this.msg = msg;
		this.loggingClass = loggingClass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public Class<?> getLoggingClass() {
		return loggingClass;
	}

	public void setLoggingClass(final Class<?> loggingClass) {
		this.loggingClass = loggingClass;
	}
}
