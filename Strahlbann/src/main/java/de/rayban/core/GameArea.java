package de.rayban.core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Shape;

import de.rayban.log.Logger;


/**
 * Repräsentiert eine Zone im Spiel mit einer "möglicherweise" speziellen Eigenschaft.
 * Z.B.: Kollision oder Todes-Zone
 *
 * @author Daniel
 *
 */
public class GameArea implements Entity {
	/** tödlich für Entities **/
	private boolean lethal;

	private final Shape area;

	private static Logger log = Logger.instance(GameArea.class);

	public GameArea(final Shape area){
		this.area = area;
	}

	/**
	 *
	 * @param rec Die Entity die mit dieser GameArea kollidiert
	 * @return true wenn eine Überschneidung des GameAreaAwares und der GameArea vorliegt
	 */
	public boolean intersects(final GameAreaAware rec) {
		return area.intersects(rec.collisionShape());
	}

	public float [] calcCollisionVector(final GameAreaAware rec){
		final float[] gaaPoints = rec.collisionShape().getPoints();
		final int pointCount = area.getPointCount();
		for(int i = 0; i<pointCount; i++){
			final float[] p1 = area.getPoint(i);
			float[] p2;
			if(i<pointCount-1){
				p2 = area.getPoint(i+1);
			} else {
				p2 = area.getPoint(0);
			}

			// Linie zwischen den Punkten konstruieren
			final float[] normal = getNormal(p1, p2);
			log.note(String.valueOf(normal[0]) + " " + String.valueOf(normal[1]));
		}

		return null;
	}

	/**
	 *
	 * @param gaa
	 * @return true wenn das GameAreaAware komplett innerhalb der GameArea liegt
	 */
	public boolean contains(final GameAreaAware gaa) {
		return area.contains(gaa.collisionShape());
	}

	public boolean isLethal() {
		return lethal;
	}

	@Override
	public boolean destroy() {
		// niemals zerstören
		return false;
	}

	@Override
	public GameAreaAware gameAreaAware() {
		return null;
	}

	@Override
	public Hitable hitable() {
		return null;
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
	public Entity setStateVisibility(final int... stateIDs) {
		return this;
	}

	@Override
	public void update(final int delta) {
	}

	@Override
	public int[] visibleForState() {
		return null;
	}

	@Override
	public void draw(final Graphics g) {
	}

	@Override
	public boolean render() {
		return false;
	}

    private float[] getNormal(final float[] start, final float[] end) {
		float dx = start[0] - end[0];
		float dy = start[1] - end[1];
		final float len = (float) Math.sqrt((dx*dx)+(dy*dy));
		dx /= len;
		dy /= len;
		return new float[] {-dy,dx};
    }
}
