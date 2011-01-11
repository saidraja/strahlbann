package de.rayban.core;

import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

/**
 * Entität der Spielwelt
 * 
 * @author Daniel
 *
 */
public interface Entity extends Renderable {
	/**
	 * 
	 * @return Wenn true entfernt der EntityManager die Entität aus dem Scene-Graph
	 */
	public boolean destroy();
	
	/**
	 * Um unötiges Casten und instanceof-Prüfungen zu vermeiden kann über diese
	 * Methode der MouseAdapter zurückgegben werden. Der Entity-Manager registriert
	 * dann den Adapter (also indirekt die Entität) beim MouseListener des GameContainers.
	 * @return MouseAdapter wenn vorhanden.
	 */
	public MouseListener receiveMouseEvents();
	
	/**
	 * Siehe receiveMouseEvents
	 * @return
	 */
	public KeyListener receiveKeyboardEvents();
	
	public Hitable hitable();

	public GameAreaAware gameAreaAware();
	
	/**
	 * Wird im Update-Zyklus des GamesContainers durch den Entity-Manger aufgerufen.
	 * @param delta
	 */
	public void update(final int delta);
	
	public int[] visibleForState();
	
	public Entity setStateVisibility(int ... stateIDs);
}
