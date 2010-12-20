package de.rayban.core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;


public class Player {
	 private static final int aimLength = 60;
	 
	private Circle body;
	 
	 private Line aim;
	 
	 private Color playerColor;
	 
	 public Player(final int radius, final int centerX, final int centerY, Color color){
		 body = new Circle(centerX, centerY, radius);
		 playerColor = color;
		 
		aim = new Line(centerX, centerY, centerX, centerY - aimLength);
	 }
	 
	 public void draw(final Graphics g, final int xMove, int yMove){
		 final Color currentColor = g.getColor();
		 g.setAntiAlias(true);
		 g.setColor(playerColor);
		 body.setCenterX(xMove);
		 float angle = 90 - (180 / body.getCenterY()) * yMove;
		 g.rotate(body.getCenterX(), body.getCenterY(), angle);
		 g.pushTransform();
		 aim.setCenterX(xMove);
		 g.popTransform();
		 g.draw(aim);
		 g.draw(body);
		 g.setColor(currentColor);
	 }
}
