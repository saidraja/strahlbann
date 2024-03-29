package de.rayban.game.actors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

import de.rayban.core.Entity;
import de.rayban.core.GameAreaAware;
import de.rayban.core.Hitable;

public class Text implements Entity {

	@Override
	public GameAreaAware gameAreaAware() {
		// TODO Auto-generated method stub
		return null;
	}

	private String text = "";

	public Text(final String text) {
		this.text = text;
	}

	@Override
	public boolean destroy() {
		return false;
	}

	@Override
	public KeyListener receiveKeyboardEvents() {
		return null;
	}

	@Override
	public MouseListener receiveMouseEvents() {
		return null;
	}

	@Override
	public void update(final int delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] visibleForState() {
		return new int[]{0,1};
	}

	@Override
	public void draw(final Graphics g) {
		g.drawString(text, 10, 100);
	}

	@Override
	public boolean render() {
		return true;
	}

	@Override
	public Entity setStateVisibility(final int... stateIDs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hitable hitable() {
		return null;
	}

}
