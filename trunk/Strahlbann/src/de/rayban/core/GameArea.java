package de.rayban.core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Shape;


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

	public GameArea(final Shape area){
		this.area = area;
	}

	/**
	 *
	 * @param rec
	 * @return true wenn eine Überschneidung des GameAreaAwares und der GameArea vorliegt
	 */
	public boolean intersects(final GameAreaAware rec) {
		return area.intersects(rec.collisionShape());
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
}
