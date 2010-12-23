package de.rayban.core;

import org.newdawn.slick.Graphics;

/**
 * 
 * @author Daniel
 *
 */
public interface Renderable {
	/**
	 * Entites überschreiben diese Methode um sich selbst zu zeichnen.
	 * 
	 * @param g
	 */
	public void draw(final Graphics g);
	
	/**
	 * 
	 * @return rendern oder nicht? Wenn false wir das Rendern ausgesetzt
	 */
	public boolean render();
}
