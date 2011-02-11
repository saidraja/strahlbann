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

	private final boolean destroyed = false;

	/**
	 * Position der Enity auf der X-Achse
	 */
	private float x;

	/**
	 * Position der Entity auf der Y-Achse
	 */
	private float y;

	@Override
	public boolean destroy() {
//		if(destroyed == false) {
//			destroyed = true;
//		}
//		return destroyed;
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
		// NOOP
	}

	@Override
	public int[] visibleForState() {
		return visibleForStates;
	}

	@Override
	public void draw(final Graphics g) {
		g.pushTransform();
		g.translate(x, y);
		drawCallback(g);
		g.popTransform();
	}

	protected void drawCallback(final Graphics g){

	}

	@Override
	public boolean render() {
		return true;
	}

	@Override
	public Entity setStateVisibility(final int... stateIDs) {
		visibleForStates = stateIDs;
		return this;
	}

	@Override
	public void mouseClicked(final int button, final int x, final int y, final int clickCount) {
	}

	@Override
	public void mouseDragged(final int oldx, final int oldy, final int newx, final int newy) {
	}

	@Override
	public void mouseMoved(final int oldx, final int oldy, final int newx, final int newy) {
	}

	@Override
	public void mousePressed(final int button, final int x, final int y) {
	}

	@Override
	public void mouseReleased(final int button, final int x, final int y) {
	}

	@Override
	public void mouseWheelMoved(final int change) {
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
	public void setInput(final Input input) {
	}

	@Override
	public void keyPressed(final int key, final char c) {
	}

	@Override
	public void keyReleased(final int key, final char c) {
	}

	@Override
	public Hitable hitable() {
		return null;
	}

	@Override
	public GameAreaAware gameAreaAware() {
		return null;
	}

	public float getX() {
		return x;
	}

	public void setX(final float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(final float y) {
		this.y = y;
	}
}