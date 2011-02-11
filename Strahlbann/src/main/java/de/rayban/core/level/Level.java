package de.rayban.core.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import de.rayban.core.logic.GameLogic;
import de.rayban.game.StrahlBann;
import de.rayban.game.states.StrahlBannGameState;

/**
 * Interface für ein Spiel-Level
 *
 * @author Stefan
 *
 */
public interface Level {

	/**
	 * initilize the level
	 * @param game
	 * @param gameState
	 * @param gameLogic
	 */
	void initLevel(StrahlBann game, StrahlBannGameState gameState,
			GameLogic gameLogic);

	/**
	 * Level-Counter
	 * @return
	 */
	public int getLevel();

	/**
	 * Mathod which ha to determine if the level is completed
	 * @return
	 */
	public boolean isLevelCompleted();

	/**
	 * Cirrent time in level
	 * @return
	 */
	public String getTime();

	/**
	 * background image of Level
	 * @return
	 */
	public Image getBackground();

	/**
	 * Method for Rendering level content
	 * @param container
	 * @param game
	 * @param g
	 */
	public void render(GameContainer container, StrahlBann game, Graphics g);

	/**
	 * Update level state
	 * @param container
	 * @param game
	 * @param delta
	 */
	public void update(GameContainer container, StrahlBann game, int delta);
}
