package de.rayban.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class InGameState extends StrahlBannGameState {

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
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer container, StrahlBann game) {
		// TODO Auto-generated method stub
		
	}

}
