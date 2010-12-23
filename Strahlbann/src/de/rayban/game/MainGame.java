package de.rayban.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import de.rayban.core.EntityManager;
import de.rayban.core.Player;

/**
 * 
 * @author Daniel
 *
 */
public class MainGame extends BasicGame {
		
	private EntityManager manager;
	
    public MainGame() {
        super("RayBan");
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	
    	int height = container.getHeight();
    	int width = container.getWidth();
    	
    	manager = new EntityManager(container);
    	Player p = new Player(40, width/2, height, Color.cyan);
    	manager.add(p);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
    	manager.update(delta);
    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.drawString("RayBan", 0, 100);
        manager.render(g);
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new MainGame());
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}