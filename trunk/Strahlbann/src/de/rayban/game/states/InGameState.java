package de.rayban.game.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import de.rayban.core.EntityManager;
import de.rayban.core.logic.GameLogic;
import de.rayban.game.StrahlBann;
import de.rayban.game.actors.Player;
import de.rayban.game.actors.Text;

/**
 * Hier wird das Spiel ansich gerendert.
 * 
 * @author Daniel
 *
 */
public class InGameState extends StrahlBannGameState {
	
	private GameLogic gameLogic;
	
	public InGameState(int id) {
		super(id);
	}

	@Override
	public void render(GameContainer container, StrahlBann game, Graphics g) {
		g.drawString("InGame", 100, 10);
		g.drawString("Score: " + gameLogic.currentScore(), 100, 50);
	}

	@Override
	public void update(GameContainer container, StrahlBann game, int delta){
		gameLogic.update(delta);
	}

	@Override
	public void init(GameContainer container, StrahlBann game) {
		gameLogic = GameLogic.start(game.getEntityManager());
		
		int height = container.getHeight();
    	int width = container.getWidth();
		
    	Player p = new Player(40, width/2, height, Color.cyan);
    	p.setStateVisibility(StrahlBann.IN_GAME_STATE);
    	
    	game.getEntityManager().add(p);
	}
	
	@Override
	public void keyReleased(int key, char c) {
		super.keyReleased(key, c);
		if (key == Input.KEY_ESCAPE) {
			game.enterState(StrahlBann.MAIN_MENU_STATE, new FadeOutTransition(Color.white), new FadeInTransition(Color.black));
		}
	}
}