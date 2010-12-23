package de.rayban.core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

public class Text implements Entity {

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
	public void update(int delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] visibleForState() {
		return new int[]{0,1};
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(text, 10, 100);
	}

	@Override
	public boolean render() {
		return true;
	}

	@Override
	public Entity setStateVisibility(int... stateIDs) {
		// TODO Auto-generated method stub
		return null;
	}

}
