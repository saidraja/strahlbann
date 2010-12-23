package de.rayban.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.rayban.core.EntityManager;
import de.rayban.core.Player;
import de.rayban.core.Text;

public class StrahlBann extends StateBasedGame {

	private EntityManager manager;
	
	public StrahlBann(String name) {
		super(name);
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if(getCurrentStateID() == 0) {
			enterState(1);
		}
		
		if(getCurrentStateID() == 1) {
			enterState(0);
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new MenuState());
		addState(new InGameState());
		
		int height = container.getHeight();
    	int width = container.getWidth();
		
		manager = new EntityManager(container);
    	Player p = new Player(40, width/2, height, Color.cyan);
    	manager.add(p);
    	manager.add(new Text("LeftMouseButton um die Stage zu wechseln"));
	}

	public EntityManager getEntityManager() {
		return this.manager;
	}
	
	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		final StrahlBann sb = new StrahlBann("Main");
		final AppGameContainer agc = new AppGameContainer(sb);
		agc.setShowFPS(false);
		agc.start();
	}

}
