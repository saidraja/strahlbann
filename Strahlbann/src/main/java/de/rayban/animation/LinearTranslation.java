package de.rayban.animation;

import de.rayban.core.BaseEntity;


public class LinearTranslation extends BaseAnimation {
	private final int xTranslation;

	private final int yTranslation;

	public LinearTranslation(final long duration, final long keyFrameInterval, final int xTranslation, final int yTranslation) {
		super(duration, keyFrameInterval, -1);
		this.xTranslation = xTranslation;
		this.yTranslation = yTranslation;
	}

	@Override
	public void doAnimation(final BaseEntity entity, final long delta) {
		final float x = entity.getX();
		entity.setX(x+xTranslation);

		final float y = entity.getY();
		entity.setY(y + yTranslation);
	}
}
