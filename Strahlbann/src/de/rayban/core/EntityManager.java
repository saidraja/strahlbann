package de.rayban.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.state.GameState;

/**
 * Simpler Entwurf eines Managers für Spiel-Entities.
 * Regelt die Registrierung von Listenern von Mouse- und Keyboard-Events und
 * das Rendern sowie Updaten der Entites. Bietet zusätzlich Möglichkeit Entities
 * bei Bedarf aus dem Scene-Graph zu löschen.
 * 
 * @author Daniel
 *
 */
public class EntityManager {
	private GameContainer container;

	/**
	 * Der "Scene-Graph". Simple Liste aller Entities die gerendert werden sollen.
	 */
	private List<Entity> entities = new ArrayList<Entity>();

	public EntityManager(final GameContainer container) {
		this.container = container;
	}

	public void add(final Entity entity) {
		final MouseListener mouseEvents = entity.receiveMouseEvents();
		if (mouseEvents != null) {
			container.getInput().addMouseListener(mouseEvents);
		}
		
		final KeyListener keyEvents = entity.receiveKeyboardEvents();
		if(keyEvents != null) {
			container.getInput().addKeyListener(keyEvents);
		}
		
		this.entities.add(entity);
	}

	public void render(final Graphics g) {
		for (Entity e : entities) {
			if (e.render()) {
				e.draw(g);
			}
		}
	}

	public void render(final Graphics g, final GameState gs) {
		for(Entity e : entities) {
			if(e.render()) {
				int[] visibleForState = e.visibleForState();
				if(visibleForState != null){
					for(int id : visibleForState) {
						if(id == gs.getID()){
							e.draw(g);
							break;
						}
					}
					continue;
				}
				e.draw(g); // wenn keine GameState-ID angegeben wurde rendern wir auf alle Fälle
			}
		}
	}
	
	public void update(final int delta) {
		List<Entity> entitiesToDestroy = new ArrayList<Entity>();
		for (Entity e : entities) {
			if(e.destroy()) {
				entitiesToDestroy.add(e);
			}
			e.update(delta);
		}
		
		for(Entity e : entitiesToDestroy) {
			entities.remove(e);
		}
	}
	
	public Iterator<Entity> entitiesIterator() {
		return entities.iterator();
	}
}
