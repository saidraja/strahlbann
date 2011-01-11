package de.rayban.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import de.rayban.game.StrahlBann;

public abstract class StrahlBannGameState extends BasicGameState {

	protected GameContainer container;
	protected StateBasedGame game;
	
	int stateId;
	
	public StrahlBannGameState(int id) {
		this.stateId = id;
	}
	
	@Override
	public int getID() {
		return stateId;
	}

	public abstract void init(GameContainer container, StrahlBann game);
	
	public abstract void render(GameContainer container, StrahlBann game, Graphics g);
	
	public abstract void update(GameContainer container, StrahlBann game, int delta);
	
	@Override
	public final void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.container = container;
		this.game = game;
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
