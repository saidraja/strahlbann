package de.rayban.game.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.Log;

import de.rayban.core.level.Level;
import de.rayban.core.level.LevelLoadException;
import de.rayban.core.level.LevelLoader;
import de.rayban.core.logic.GameLogic;
import de.rayban.game.StrahlBann;

/**
 * Hier wird das Spiel ansich gerendert.
 *
 * @author Daniel
 */
public class InGameState extends StrahlBannGameState {

	private GameLogic gameLogic;

	private int currentLevelCounter = 0;

	private Level currentLevel;

	public InGameState(final int id) {
		super(id);
	}

	@Override
	public void init(final GameContainer container, final StrahlBann game) {
		// GameLogic initialisieren
		gameLogic = GameLogic.start(game.getEntityManager());
		loadNextLevel(game);
	}

	@Override
	public void render(final GameContainer container, final StrahlBann game,
			final Graphics g) {
		currentLevel.render(container,game, g);

	}

	@Override
	public void update(final GameContainer container, final StrahlBann game,
			final int delta) {
		gameLogic.update(delta);
		currentLevel.update(container, game, delta);

		if (currentLevel.isLevelCompleted() == true) {
			loadNextLevel(game);
		}
	}

	private void loadNextLevel(final StrahlBann game) {
		try {
			currentLevelCounter++;
			currentLevel = LevelLoader.loadLevel(currentLevelCounter);
			currentLevel.initLevel(game, this, gameLogic);
		} catch (final LevelLoadException e) {
			Log.error("Loading of level " + currentLevelCounter + " failed.", e);
		}
	}

	@Override
	public void keyReleased(final int key, final char c) {
		super.keyReleased(key, c);
		if (key == Input.KEY_ESCAPE) {
			game.enterState(StrahlBann.MAIN_MENU_STATE, new FadeOutTransition(
					Color.black), new FadeInTransition(Color.black));
		}
	}
}
