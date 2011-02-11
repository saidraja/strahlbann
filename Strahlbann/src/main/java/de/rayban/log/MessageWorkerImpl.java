package de.rayban.log;

public class MessageWorkerImpl implements MessageWorker {

	@Override
	public void doMessage(final Message msg, final int logLevel) {
		System.out.println(logLevelForMsg(logLevel) + " ["+msg.getLoggingClass().getCanonicalName()+"]: " + msg.getMsg());
	}

	private String logLevelForMsg(final int logLevel){
		switch(logLevel){
		case 1: return "INFO";
		case 2: return "NOTE";
		case 3: return "WARN";
		case 4: return "ERROR";
		default: return "";
		}
	}
}
