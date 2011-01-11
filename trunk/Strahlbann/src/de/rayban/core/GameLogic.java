package de.rayban.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	/** Spielzonen die eine besondere Auswirkung auf Entities haben */
	private List<GameArea> areas;

	private static GameLogic instance;

	private EntityManager manager;

	/**
	 * Internen Status zurücksetzen und alle notwendigen Initialisierunge vornehmen
	 */
	public static GameLogic start(final EntityManager entityManager){
		instance = new GameLogic();
		instance.manager = entityManager;
		instance.manager.add(new Enemy());
		instance.initGameAreas();
		return instance;
	}

	/**
	 * Spiel-Status aktualisieren.
	 * @param delta TODO
	 */
	public void update(final int delta){
		final Iterator<Entity> entitiesIterator = manager.entitiesIterator();
		while(entitiesIterator.hasNext()) {
			final Entity entity = entitiesIterator.next();
			updateScore(entity);
			updateGameAreaEntityRelation(entity);
		}
		manager.update(delta);
	}

	private void initGameAreas() {
		areas = new ArrayList<GameArea>();
		// TODO
	}

	/**
	 * Prüft auf Kollisionen bzw. vollständige Überlappungen von Entities
	 * und GameAreas.
	 */
	private void updateGameAreaEntityRelation(final Entity entity) {
		if(entity.gameAreaAware() != null) {
			for(final GameArea g : areas) {
				if(g.contains(entity.gameAreaAware()) && g.isLethal()){
					entity.destroy();
				}
				// Aktionen ausführen
			}
		}
	}

	private void updateScore(final Entity entity) {
		if(entity.hitable() != null && entity.hitable().hitReceived()) {
			score += entity.hitable().hitScore();
		}
	}

	public String currentScore() {
		return String.valueOf(score);
	}

	//
	// Getter- und Setter-Methoden
	//
	public EntityManager getEntityManager() {
		return manager;
	}
}
