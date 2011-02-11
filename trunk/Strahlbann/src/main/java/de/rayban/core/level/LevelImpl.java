package de.rayban.core.level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import de.rayban.core.level.util.Clock;
import de.rayban.core.logic.GameLogic;
import de.rayban.game.StrahlBann;
import de.rayban.game.actors.Player;
import de.rayban.game.actors.Ray;
import de.rayban.game.states.StrahlBannGameState;

public class LevelImpl implements Level {

	private Clock levelClock;

	private int level;

	private String backgroundFile;

	private GameLogic gameLogic;

	@Override
	public void initLevel(final StrahlBann game, final StrahlBannGameState gameState, final GameLogic gameLogic) {

		this.gameLogic = gameLogic;

		// load level from descrption file
		// todo Format und Inhalt überlegen
		levelClock = new Clock();

		final int height = game.getContainer().getHeight();
		final int width = game.getContainer().getWidth();

		final Player p = new Player(40, width / 2, height, Color.cyan);
		p.setStateVisibility(StrahlBann.IN_GAME_STATE);

		final Ray ray = new Ray(2, 3, Color.blue, 30, 40);
		game.getEntityManager().add(p, ray);
	}

	@Override
	public Image getBackground() {
		// Hintergrundbild setzen
		// Pfad zu Bild aus Leveldaten holen)
		try {
			return new Image(backgroundFile);
		} catch (final SlickException e) {
			Log.error("Could not set level background", e);
		}
		return null;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getTime() {
		return levelClock.getTime();
	}

	@Override
	public boolean isLevelCompleted() {
		return false;
	}

	@Override
	public void render(final GameContainer container, final StrahlBann game, final Graphics g) {
		getBackground().draw(0, 0);
		g.setColor(Color.gray);
		g.drawRoundRect(490, 20, 130, 65, 10);

		g.drawString("Level: " + level, 500,25);
		g.drawString("Score: " + gameLogic.currentScore(), 500,40);
		g.drawString(" Time: " + getTime(), 500, 55);
	}

	@Override
	public void update(final GameContainer container, final StrahlBann game, final int delta) {
		levelClock.update(delta);
	}

	public void setBackgroundFile(final String background) {
		this.backgroundFile = background;
	}

	public void setLevel(final int level) {
		this.level = level;
	}
}
