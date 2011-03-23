package de.rayban.animation;

import de.rayban.core.BaseEntity;

public interface IAnimation {
	public static final int ANIMATION_NOTYETSTARTED = 0;

	public static final int ANIMATION_PAUSED = 1;

	public static final int ANIMATION_RUNNING = 2;

	public static final int ANIMATION_STOPPED = 3;

	/**
	 * Modifiziert die x und y Position der Entity.
	 *
	 * @param entity Entität die animiert werden soll,
	 * sprich deren x / y Position manipuliert werden soll.
	 * @param delta TODO
	 */
	public void animate(final BaseEntity entity, long delta);

	public IAnimation pause();

	public IAnimation start();

	public IAnimation stop();
}
