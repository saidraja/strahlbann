package de.rayban.core;

import org.newdawn.slick.geom.Shape;

/**
 * GameAreaAwares sind sich ihrer Umwelt bewusst, d.h.
 * sie "wissen" dass es noch weitere Objekte gibt mit denen
 * sie in Interaktion treten können.
 *
 * @author Daniel
 *
 */
public interface GameAreaAware {
	/**
	 * Liefert die Bounding-Box der Entity.
	 * @return
	 */
	public Shape collisionShape();
}
