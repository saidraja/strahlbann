package de.rayban.core;

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
		return instance;
	}
	
	/**
	 * Spiel-Status aktualisieren.
	 */
	public void update(){
		updateScore();
	}

	private void updateScore() {
		while(manager.entitiesIterator().hasNext()) {
			final Entity entity = manager.entitiesIterator().next();
			if(entity.hitable() != null) {
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
}
