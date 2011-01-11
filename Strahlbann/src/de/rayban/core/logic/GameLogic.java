package de.rayban.core.logic;

import java.util.Iterator;

import de.rayban.core.Entity;
import de.rayban.core.EntityManager;
import de.rayban.game.actors.Enemy;

/**
 * Hier findet alles seinen Platz was das Spiel steuert.
 * 
 * Z.B.: Wann neue Gegner das Spielfeld betreten, Punktestand etc.
 * 
 * @author Daniel
 *
 */
public class GameLogic {
	/** erspielte Punkte */
	private long score = 0L;
	
	private static GameLogic instance;
	
	private EntityManager manager;
	
	/**
	 * Internen Status zurücksetzen und alle notwendigen Initialisierunge vornehmen
	 */
	public static GameLogic start(EntityManager entityManager){
		instance = new GameLogic();
		instance.manager = entityManager;
		instance.manager.add(new Enemy());
		return instance;
	}
	
	/**
	 * Spiel-Status aktualisieren.
	 * @param delta TODO
	 */
	public void update(int delta){
		updateScore();
		manager.update(delta);
	}

	private void updateScore() {
		final Iterator<Entity> entitiesIterator = manager.entitiesIterator();
		while(entitiesIterator.hasNext()) {
			final Entity entity = entitiesIterator.next();
			if(entity.hitable() != null && entity.hitable().hitReceived()) {
				score += entity.hitable().hitScore();
			}
		}
	}
	
	//
	// Getter- und Setter-Methoden
	//
	public EntityManager getEntityManager() {
		return manager;
	}

	public String currentScore() {
		return String.valueOf(score);
	}
}
