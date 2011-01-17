package de.rayban.core.level;

public class LevelLoadException extends Exception {

	private static final long serialVersionUID = -2723642954109978916L;

	public LevelLoadException() {
		super("Could not initialize level");
	}

	public LevelLoadException(final Throwable ex) {
		super("Could not initialize level", ex);
	}
}
