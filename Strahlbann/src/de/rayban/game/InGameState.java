package de.rayban.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import de.rayban.core.GameLogic;

public class InGameState extends StrahlBannGameState {
	
	private GameLogic gameLogic;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void render(GameContainer container, StrahlBann game, Graphics g) {
		g.drawString("InGame", 100, 10);
	}

	@Override
	public void update(GameContainer container, StrahlBann game, int delta){
		gameLogic.update();
	}

	@Override
	public void init(GameContainer container, StrahlBann game) {
		gameLogic = GameLogic.start(game.getEntityManager());
	}

}
