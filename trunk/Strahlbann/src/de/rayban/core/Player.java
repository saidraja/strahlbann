package de.rayban.core;

import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;

import de.rayban.controll.KeyboardAdapter;
import de.rayban.controll.MouseAdapter;

/**
 * Die Spielerfigur.
 * 
 * @author Daniel
 * 
 */
public class Player extends MouseAdapter implements Entity {
	private static final int aimLength = 60;

	private Circle body;

	private Line aim;

	private Color playerColor;

	/**
	 * Hält die Position der Mouse im Spielfeld. Wird zum Rendern benötigt.
	 */
	private Point mousePosition = new Point();

	public Player(final int radius, final int centerX, final int centerY,
			Color color) {
		body = new Circle(centerX, centerY, radius);
		playerColor = color;

		aim = new Line(centerX, centerY, centerX, centerY - aimLength);
	}

	@Override
	public void draw(Graphics g) {
		final Color currentColor = g.getColor();
		g.setAntiAlias(true);
		g.setColor(playerColor);
		body.setCenterX(mousePosition.x);
		float angle = 90 - (180 / body.getCenterY()) * mousePosition.y;
		g.rotate(body.getCenterX(), body.getCenterY(), angle);
		g.pushTransform();
		aim.setCenterX(mousePosition.x);
		g.popTransform();
		g.draw(aim);
		g.draw(body);
		g.setColor(currentColor);
	}

	/**
	 * Wenn die Mouse bewegt wurde interessieren wir uns für die absoulte
	 * Position der Mouse im Spielfeld.
	 */
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		mousePosition.x = newx;
		mousePosition.y = newy;
	}

	@Override
	public boolean destroy() {
		return false; // niemals zerstören
	}

	@Override
	public boolean render() {
		return true; // Immer anzeigen
	}

	@Override
	public MouseAdapter receiveMouseEvents() {
		return this;
	}

	@Override
	public void update(int delta) {
		// nichts zu tun hier
	}

	@Override
	public KeyboardAdapter receiveKeyboardEvents() {
		return null; // hört nicht auf Tastatureingaben
	}
}
