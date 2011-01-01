package de.rayban.core;

public class EntityHitListener implements Hitable {
	public long readyToHitTime;
	
	public long hitTime;

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
		return 0;
	}

}
