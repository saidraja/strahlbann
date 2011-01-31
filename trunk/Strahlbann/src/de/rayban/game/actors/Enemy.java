package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;

import de.rayban.core.BaseEntity;
import de.rayban.core.EntityHitListener;
import de.rayban.core.GameAreaAware;
import de.rayban.core.Hitable;
import de.rayban.game.StrahlBann;

/**
 *
 * @author Daniel
 *
 */
public class Enemy extends BaseEntity {
	private final Hitable hitable = new EntityHitListener();

	private int lastTick = 0;

	@Override
	public void update(final int delta) {
		if(lastTick == 0){
			lastTick = delta;
		}

		final int tickDiff = delta - lastTick;
		if(tickDiff > 100){
			setX(getX()+10);
		}
		lastTick = delta;
	}

	@Override
	protected void drawCallback(final Graphics g) {
		g.drawOval(20, 20, 40, 40);
	}

	@Override
	public boolean destroy() {
		return hitable.hitReceived();
	}

	@Override
	public MouseListener receiveMouseEvents() {
		return this;
	}

	@Override
	public Hitable hitable() {
		return hitable;
	}

	@Override
	public void mouseClicked(final int button, final int x, final int y, final int clickCount) {
		hitable.hit();
	}

	@Override
	public GameAreaAware gameAreaAware() {
		return super.gameAreaAware();
	}
	@Override
	public int[] visibleForState() {
		return new int[]{StrahlBann.IN_GAME_STATE};
	}
}
