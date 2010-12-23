package de.rayban.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class MenuState extends StrahlBannGameState {
	
	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void render(GameContainer container, StrahlBann game, Graphics g) {
		g.drawString("Menü", 50, 10);
	}

	@Override
	public void update(GameContainer container, StrahlBann game, int delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer container, StrahlBann game) {
		// TODO Auto-generated method stub
		
	}

}
