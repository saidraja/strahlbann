package de.rayban.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class StrahlBannGameState extends BasicGameState {

	@Override
	public abstract int getID();

	public abstract void init(GameContainer container, StrahlBann game);
	
	public abstract void render(GameContainer container, StrahlBann game, Graphics g);
	
	public abstract void update(GameContainer container, StrahlBann game, int delta);
	
	@Override
	public final void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		StrahlBann sb = (StrahlBann) game;
		init(container, sb);
	}
	
	@Override
	public final void render(GameContainer container, StateBasedGame game, Graphics g) {
		StrahlBann sb = (StrahlBann) game;
		sb.getEntityManager().render(g, game.getCurrentState());
		render(container, (StrahlBann)game, g);
	}

	@Override
	public final void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		update(container, (StrahlBann)game, delta);
	}
}
