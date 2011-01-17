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
	private final boolean lethal;

	public GameArea(final float x, final float y, final float width, final float height, final boolean lethal) {
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