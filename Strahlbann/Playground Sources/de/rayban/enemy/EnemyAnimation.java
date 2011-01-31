package de.rayban.enemy;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import de.rayban.core.EntityManager;
import de.rayban.core.logic.GameLogic;
import de.rayban.game.actors.Enemy;
import de.rayban.log.Logger;

public class EnemyAnimation extends BasicGame {
	private GameLogic gameLogic;

	private EntityManager manager;

	private final Logger log;

	public EnemyAnimation(final String title) {
		super(title);
		log = Logger.instance(EnemyAnimation.class);
	}

	@Override
	public void init(final GameContainer container) throws SlickException {
		manager = new EntityManager(container);
		gameLogic = GameLogic.start(manager);
		final Enemy e = new Enemy();
		manager.add(e);
	}

	@Override
	public void update(final GameContainer container, final int delta)
			throws SlickException {
		gameLogic.update(delta);
		log.note("Update wurde aufgerufen");
	}

	@Override
	public void render(final GameContainer container, final Graphics g)
			throws SlickException {
		manager.render(g);
		log.note("Render wurde aufgerufen");
	}

	public static void main(final String [] argv) throws SlickException{
		final EnemyAnimation sb = new EnemyAnimation("simpleSprite");
		final AppGameContainer agc = new AppGameContainer(sb);
		agc.setAlwaysRender(true);
		agc.start();
	}
}
