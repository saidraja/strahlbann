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
 * Simpler Entwurf eines Managers für Spiel-Entities. Regelt die Registrierung
 * von Listenern von Mouse- und Keyboard-Events und das Rendern sowie Updaten
 * der Entites. Bietet zusätzlich Möglichkeit Entities bei Bedarf aus dem
 * Scene-Graph zu löschen.
 *
 * @author Daniel
 *
 */
public class EntityManager implements Iterable<Entity> {

	private final GameContainer container;

	/**
	 * Der "Scene-Graph". Simple Liste aller Entities die gerendert werden
	 * sollen.
	 */
	private final List<Entity> entities = new ArrayList<Entity>();

	public EntityManager(final GameContainer container) {
		this.container = container;
	}

	/**
	 * Adds one or more entities to manager and registers new entities as
	 * listener
	 *
	 * @param entitiesToAdd new entities
	 */
	public void add(final Entity... entitiesToAdd) {
		for (final Entity entity : entitiesToAdd) {
			final MouseListener mouseEvents = entity.receiveMouseEvents();
			if (mouseEvents != null) {
				container.getInput().addMouseListener(mouseEvents);
			}

			final KeyListener keyEvents = entity.receiveKeyboardEvents();
			if (keyEvents != null) {
				container.getInput().addKeyListener(keyEvents);
			}

			this.entities.add(entity);
		}
	}

	public void render(final Graphics g) {
		for (final Entity e : entities) {
			if (e.render()) {
				e.draw(g);
			}
		}
	}

	/**
	 * Rendern in Abhängigkeit des gerade gewählten Game-States
	 * @param g
	 * @param gs
	 */
	public void render(final Graphics g, final GameState gs) {
		for (final Entity e : entities) {
			if (e.render()) {
				final int[] visibleForState = e.visibleForState();
				if (visibleForState != null) {
					for (final int id : visibleForState) {
						if (id == gs.getID()) {
							e.draw(g);
							break;
						}
					}
					continue;
				}
				e.draw(g); // wenn keine GameState-ID angegeben wurde rendern
							// wir auf alle Fälle
			}
		}
	}

	public void update(final int delta) {
		final List<Entity> entitiesToDestroy = new ArrayList<Entity>();
		for (final Entity e : entities) {
			if (e.destroy()) {
				entitiesToDestroy.add(e);
			}
			e.update(delta);
		}

		for (final Entity e : entitiesToDestroy) {
			entities.remove(e);
		}
	}

	@Override
	public Iterator<Entity> iterator() {
		return entities.iterator();
	}
}