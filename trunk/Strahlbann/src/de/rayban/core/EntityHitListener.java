package de.rayban.core;

/**
 *
 * @author Daniel
 *
 */
public class EntityHitListener implements Hitable {
	/**
	 * System.currentTimeMillis wann das Hitable Bereitschaft
	 * signalisierte Treffer zu empfangen
	 */
	public long readyToHitTime;

	/**
	 * System.currentTimeMillis wann das Hitable als getroffen markiert wurde
	 */
	public long hitTime;

	/**
	 * Zeitdauer zwischen Start der Bereitschaft (Treffer empfangen) und
	 * dem ersten Treffer
	 */
	@Override
	public long livingTimeTillHit() {
		return hitTime - readyToHitTime;
	}

	@Override
	public void hit() {
		hitTime = System.currentTimeMillis();
	}

	@Override
	public void readyToHit() {
		readyToHitTime = System.currentTimeMillis();
	}

	@Override
	public boolean hitReceived() {
		return hitTime==0L?false:true;
	}

	@Override
	public long hitScore() {
		// TODO
		return 1;
	}

	@Override
	public void reset() {
		hitTime = 0L;
		readyToHitTime = 0L;
	}
}
