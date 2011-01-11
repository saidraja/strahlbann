package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;

import de.rayban.core.BaseEntity;
import de.rayban.core.EntityHitListener;
import de.rayban.core.Hitable;

/**
 * 
 * @author Daniel
 *
 */
public class Enemy extends BaseEntity {
	private Hitable hitable = new EntityHitListener();
	
	@Override
	public void draw(Graphics g) {
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
	public void mouseClicked(int button, int x, int y, int clickCount) {
		hitable.hit();
	}

}
