package de.rayban.core;

import org.newdawn.slick.geom.Rectangle;

/**
 * Repräsentiert eine Zone im Spiel mit einer "möglicherweise" speziellen Eigenschaft.
 * Z.B.: Kollision oder Todes-Zone
 * 
 * @author Daniel
 *
 */
public class GameArea extends Rectangle {
	/** tödlich für Entities **/
	private boolean lethal;
	
	public GameArea(float x, float y, float width, float height, boolean lethal) {
		super(x, y, width, height);
		this.lethal = lethal;
	}
	
	/**
	 * 
	 * @param rec
	 * @return true wenn eine Überschneidung des GameAreaAwares und der GameArea vorliegt
	 */
	public boolean intersects(final GameAreaAware rec) {
		return this.intersects(rec.collisionShape());
	}
	
	/**
	 * 
	 * @param gaa
	 * @return true wenn das GameAreaAware komplett innerhalb der GameArea liegt
	 */
	public boolean contains(final GameAreaAware gaa) {
		return this.contains(gaa.collisionShape());
	}
	
	public boolean isLethal() {
		return lethal;
	}
}
