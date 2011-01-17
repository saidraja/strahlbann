package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;

import de.rayban.core.BaseEntity;
import de.rayban.core.EntityHitListener;
import de.rayban.core.Hitable;
import de.rayban.game.StrahlBann;

/**
 *
 * @author Daniel
 *
 */
public class Enemy extends BaseEntity {
	private final Hitable hitable = new EntityHitListener();

	@Override
	public void draw(final Graphics g) {
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
	public int[] visibleForState() {
		return new int[]{StrahlBann.IN_GAME_STATE};
	}
}
