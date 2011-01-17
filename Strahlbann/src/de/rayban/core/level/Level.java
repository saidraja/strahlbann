package de.rayban.core.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import de.rayban.core.logic.GameLogic;
import de.rayban.game.StrahlBann;
import de.rayban.game.states.StrahlBannGameState;

public interface Level {

	public int getLevel();

	public boolean isLevelCompleted();

	public String getTime();

	public Image getBackground();

	public void render(GameContainer container, StrahlBann game, Graphics g);

	void initLevel(StrahlBann game, StrahlBannGameState gameState,
			GameLogic gameLogic);

	public void update(GameContainer container, StrahlBann game, int delta);
}
