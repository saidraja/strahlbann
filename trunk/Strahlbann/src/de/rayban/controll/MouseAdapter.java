package de.rayban.controll;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 * Simple Hilfsklasse um in potentiellen MouseListener Klassen nicht immer
 * alle Methoden des Interfaces implementieren zu müssen.
 * 
 * @author Daniel
 *
 */
public abstract class MouseAdapter implements MouseListener {

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	/**
	 * Hiermit kann man bestimmen ob Mouse-Events für diesen Adapter abgearbeitet werden sollen
	 * oder nicht. Praktisch falls die Steuerung per Maus für einen bestimmten Zeitraum unterbunden werden soll.
	 */
	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input input) {
		// TODO Auto-generated method stub

	}

}
