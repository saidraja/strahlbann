package de.rayban.core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

/**
 * 
 * @author Daniel
 *
 */
public class BaseEntity implements Entity, MouseListener, KeyListener {

	private int [] visibleForStates;
	
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
		// NOOP
	}

	@Override
	public int[] visibleForState() {
		return visibleForStates;
	}

	@Override
	public void draw(Graphics g) {
		// NOOP
	}

	@Override
	public boolean render() {
		return true;
	}

	@Override
	public Entity setStateVisibility(int... stateIDs) {
		visibleForStates = stateIDs;
		return this;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
	}

	@Override
	public void mousePressed(int button, int x, int y) {
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
	}

	@Override
	public void mouseWheelMoved(int change) {	
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {	
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input input) {		
	}

	@Override
	public void keyPressed(int key, char c) {
	}

	@Override
	public void keyReleased(int key, char c) {	
	}
}