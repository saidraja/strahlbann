package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;

import de.rayban.core.BaseEntity;
import de.rayban.core.EntityHitListener;
import de.rayban.core.GameAreaAware;
import de.rayban.core.Hitable;
import de.rayban.game.StrahlBann;
import de.rayban.log.Logger;

/**
 *
 * @author Daniel
 *
 */
public class Enemy extends BaseEntity {
	private final Hitable hitable = new EntityHitListener();

	private int lastTick = 0;

	private final Logger log = Logger.instance(Enemy.class);

	@Override
	public void update(final int delta) {
		lastTick += delta;

		if(lastTick > 40){
			final float x = getX();
			setX(x+10);
			lastTick = 0;
		}

		if(getX() > 200){
			setX(0);
		}
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
