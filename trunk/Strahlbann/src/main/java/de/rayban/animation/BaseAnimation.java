package de.rayban.animation;

import de.rayban.core.BaseEntity;

public abstract class BaseAnimation implements IAnimation {

	/**
	 * Gesamtlaufdauer der Animation in Millisekunden.
	 * Wenn 0 läuft die Animation unendlich.
	 */
	private final long duration;

	private long currentDuration;

	/** Millisekunden zwischen zwei Keyframes */
	private final long keyFrameInterval;

	/**
	 * Anzahl der Wiederholungen, wenn -1 wird die Animation unendlich
	 * oft wiederholt.
	 */
	private final int repeat;

	private int currentRepeatations;

	private int animationStatus = IAnimation.ANIMATION_NOTYETSTARTED;

	private final int lastTick = 0;

	public BaseAnimation(final long duration, final long keyFrameInterval, final int repeat) {
		this.duration = duration;
		this.keyFrameInterval = keyFrameInterval;
		this.repeat = repeat;
	}

	public final void animate(final BaseEntity entity, final long delta) {
		if(animationStatus == IAnimation.ANIMATION_STOPPED || animationStatus == IAnimation.ANIMATION_PAUSED){
			return;
		}

		if(duration > 0L){
			currentDuration += delta;
			if(currentDuration > duration) {
				if(repeat > -1 && currentRepeatations > repeat){
					animationStatus = IAnimation.ANIMATION_STOPPED;
					return;
				}

				if(repeat > 0){
					currentRepeatations++;
				}
				currentDuration = 0;
			}
		}

//		lastTick += delta;

//		if(lastTick > getKeyFrameInterval()){
			doAnimation(entity, delta);
//			lastTick = 0;
//		}
	}

	public abstract void doAnimation(final BaseEntity entity, final long delta);

	@Override
	public IAnimation pause() {
		animationStatus = IAnimation.ANIMATION_PAUSED;
		return this;
	}

	@Override
	public IAnimation start() {
		animationStatus = IAnimation.ANIMATION_RUNNING;
		return this;
	}

	@Override
	public IAnimation stop() {
		animationStatus = IAnimation.ANIMATION_STOPPED;
		return this;
	}

	public long getDuration() {
		return duration;
	}

	public long getKeyFrameInterval() {
		return keyFrameInterval;
	}

	public int getStatus() {
		return animationStatus;
	}
}
