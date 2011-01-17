package de.rayban.game.states;

import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.Log;

import de.rayban.game.StrahlBann;

/**
 * @author Daniel
 * @author Stefan
 */
public class MenuState extends StrahlBannGameState {

	/** menu entries to display */
	public List<String> menuOptions = Arrays.asList("Start Game", "Options", "High Score", "About StrahlBann", "Quit Game");

	/** background image of main menu */
	private Image background = null;

	// TODO stefan durch UniCodeFont ersetzen
	TrueTypeFont entryFont;
	TrueTypeFont infoFont;

	public MenuState(final int id) {
		super(id);
	}

	@Override
	public void init(final GameContainer container, final StrahlBann game) {
		try {
			background = new Image("resources/images/menu_background.png");

			entryFont = new TrueTypeFont(new Font("Verdana", Font.BOLD, 25), true);
			infoFont= new TrueTypeFont(new Font("Verdana", Font.ITALIC, 10), true);
		} catch (final SlickException e) {
			Log.error("Could not find backgrond image.", e);
		}
	}

	@Override
	public void render(final GameContainer container, final StrahlBann game, final Graphics g) {
		// draw background
		background.draw(0,0);

		// draw menu options
		int yPos = 100;
		for (final String menuEntry : menuOptions) {
			entryFont.drawString(150, yPos, menuEntry);
			yPos+=50;
		}

		// draw info
		infoFont.drawString(10, container.getHeight() -20, "by Daniel Ludwig and Stefan Stützer");
	}

	@Override
	public void update(final GameContainer container, final StrahlBann game, final int delta) {
		container.getInput();


	}

	@Override
	public void keyReleased(final int key, final char c) {
		super.keyReleased(key, c);

		if (key == Input.KEY_1) {
			game.enterState(StrahlBann.IN_GAME_STATE, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}

		if (key == Input.KEY_ESCAPE) {
			Log.info("Quit Strahlbann");
			System.exit(1);
		}

		if (key == Input.KEY_F2) {
			try {
				container.setFullscreen(!container.isFullscreen());
			} catch (final SlickException e) {
				Log.error(e);
			}
		}
	}
}
