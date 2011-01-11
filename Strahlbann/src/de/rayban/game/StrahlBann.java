package de.rayban.game;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import de.rayban.core.EntityManager;
import de.rayban.game.actors.Player;
import de.rayban.game.actors.Text;
import de.rayban.game.states.InGameState;
import de.rayban.game.states.MenuState;

public class StrahlBann extends StateBasedGame {

	public static final int MAIN_MENU_STATE = 0;
	public static final int IN_GAME_STATE = 1;
	public static final int SETTING_STATE = 2;
	public static final int HIGH_SCORE_STATE = 3;
	
	
	private EntityManager manager;
	
	public StrahlBann(String name) {
		super(name);
		
		this.addState(new MenuState(MAIN_MENU_STATE));
		this.addState(new InGameState(IN_GAME_STATE));
		this.enterState(MAIN_MENU_STATE);
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		manager = new EntityManager(container);

		this.getState(MAIN_MENU_STATE).init(container, this);
		this.getState(IN_GAME_STATE).init(container, this);
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
