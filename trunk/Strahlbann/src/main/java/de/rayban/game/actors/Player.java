package de.rayban.game.actors;

import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;

import de.rayban.core.BaseEntity;

/**
 * Die Spielerfigur.
 * 
 * @author Daniel
 * 
 */
public class Player extends BaseEntity {
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
		setStateVisibility(0, 1);
	}

	@Override
	public void draw(Graphics g) {
		final Color currentColor = g.getColor();
		g.setAntiAlias(true);
		g.setColor(playerColor);
		body.setCenterX(mousePosition.x);
		
		
		g.pushTransform();
		float angle = 90 - (180 / body.getCenterY()) * mousePosition.y;
		g.rotate(body.getCenterX(), body.getCenterY(), angle);
		aim.setCenterX(mousePosition.x);
		g.draw(aim);
		g.draw(body);
		g.setColor(currentColor);
		
		g.popTransform();
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
	public MouseListener receiveMouseEvents() {
		return this;
	}
}
