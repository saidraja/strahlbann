package de.rayban.core.level;

/**
 *
 * @author Stefan
 */
public class LevelLoader {

	public static Level loadLevel(final int level) throws LevelLoadException {
		// TODO Level Daten aus Datei laden
		final LevelImpl levelImpl = new LevelImpl();
		levelImpl.setLevel(1);
		levelImpl.setBackgroundFile("resources/images/background_level_1.png");
		return levelImpl;
	}

}
