package de.rayban.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.rayban.core.EntityManager;

public abstract class StrahlBannGameState extends BasicGameState {

	private EntityManager manager;
	
	@Override
	public abstract int getID();

	public abstract void init(GameContainer container, StrahlBann game);
	
	public abstract void render(GameContainer container, StrahlBann game, Graphics g);
	
	public abstract void update(GameContainer container, StrahlBann game, int delta);
	
	@Override
	public final void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		StrahlBann sb = (StrahlBann) game;
		manager = sb.getEntityManager();
		init(container, sb);
	}
	
	@Override
	public final void render(GameContainer container, StateBasedGame game, Graphics g) {
		manager.render(g, game.getCurrentState());
		render(container, (StrahlBann)game, g);
	}

	@Override
	public final void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		update(container, (StrahlBann)game, delta);
	}
	
	public EntityManager getManager() {
		return manager;
	}

}
