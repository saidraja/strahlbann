package de.rayban.game.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;

import de.rayban.core.BaseEntity;
import de.rayban.core.EntityHitListener;
import de.rayban.core.Hitable;

/**
 * @author Stefan
 */
public class Ray extends BaseEntity {

	private final Integer FLY = 0;
	private final Integer ABSORB = 1;
	private final Integer REFLECT = 2;


    private final Color color;
    private final Integer length;
    private final Integer xPosStart;
    private final Integer xDir;
    private Integer yDir;
    private Integer mode = FLY;

    private final Integer r;

    private final Line ray;

    private final Hitable hitable = new EntityHitListener();

    public Ray(final Integer xDir, final Integer yDir, final Color color, final Integer length, final Integer xPosStart){
    	this.color = color;
    	this.length = length;
    	this.xPosStart = xPosStart;
    	this.xDir = xDir;
    	this.yDir = yDir;
    	r = yDir / xDir;
    	ray = new Line((float)(- (length / java.lang.Math.sqrt(((r * r)  + 1))) + xPosStart),
        		(float)(- r * (length / java.lang.Math.sqrt(((r * r)  + 1)))),
        		xPosStart.floatValue(),
        		0f);
    }

    @Override
	public Hitable hitable() {
		return hitable;
	}

	/**
    * Momentan nur Spezialfall Spiegelung an X-Achse
    */
    @Override
	public void draw (final Graphics g) {
        double currentLength = 0;
        final short epsilon = 2;

        g.pushTransform();

        if (mode != FLY) {
            final double x = java.lang.Math.pow(ray.getX1() - ray.getX2(), 2);
            final double y = java.lang.Math.pow(ray.getY1() - ray.getY2(), 2);
            currentLength = java.lang.Math.sqrt(x+y);
            if (currentLength >= length && mode == REFLECT) {
//                ray.translateX += xDir;
//                ray.translateY += yDir;
            	g.translate(xDir, yDir);
                   mode = FLY;
            }
        }

        if (mode == ABSORB && currentLength < epsilon) {
//            ray.startX = ray.endX;
//            ray.startY = ray.endY;
        	ray.set(ray.getX2(), ray.getY2(), ray.getX2(), ray.getY2());
            yDir = -yDir;
            mode = REFLECT;

        }

        if (mode == FLY) {
//            ray.translateX += xDir;
//            ray.translateY += yDir;
        	g.translate(xDir, yDir);
        } else if (mode == ABSORB){
//            ray.startX += xDir;
//            ray.startY += yDir;
        	ray.set(ray.getX1()+xDir, ray.getY1()+yDir, ray.getX2(), ray.getY2());
        } else if (mode == REFLECT) {
//            ray.endX += xDir;
//            ray.endY += yDir;
        	ray.set(ray.getX1(), ray.getY1(), ray.getX2()+xDir, ray.getY2()+yDir);
        }

        g.draw(ray);
        g.popTransform();
    }

    public void reflect() {
        if (mode == FLY) {
            mode = ABSORB;
        }
    }
}