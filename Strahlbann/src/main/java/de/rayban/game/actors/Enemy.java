package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;

import de.rayban.animation.IAnimation;
import de.rayban.animation.LinearTranslation;
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

	public Enemy() {
		super();
		getAnimations().add(new LinearTranslation(0, 40, 3, 0).pause());
		getAnimations().add(new LinearTranslation(0, 40, 0, 3).pause());
	}

	@Override
	protected void drawCallback(final Graphics g) {
		g.drawOval(20, 20, 40, 40);
	}

	@Override
	public boolean destroy() {
//		return hitable.hitReceived();
		return false;
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
		for(final IAnimation anim : getAnimations()){
			anim.start();
		}
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
