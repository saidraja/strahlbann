package de.rayban.core;

import de.rayban.controll.KeyboardAdapter;
import de.rayban.controll.MouseAdapter;

/**
 * Entität der Spielwelt
 * 
 * @author Daniel
 *
 */
public interface Entity extends Renderable {
	/**
	 * 
	 * @return rendern oder nicht? Wenn false wir das Rendern ausgesetzt
	 */
	public boolean render();
	
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
	public MouseAdapter receiveMouseEvents();
	
	/**
	 * Siehe receiveMouseEvents
	 * @return
	 */
	public KeyboardAdapter receiveKeyboardEvents();
	
	/**
	 * Wird im Update-Zyklus des GamesContainers durch den Entity-Manger aufgerufen.
	 * @param delta
	 */
	public void update(final int delta);
}
