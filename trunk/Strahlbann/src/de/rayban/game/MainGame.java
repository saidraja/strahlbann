package de.rayban.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.SimpleDiagramRenderer;

import de.rayban.core.Player;

public class MainGame extends BasicGame {
	
	private Player p;
	
    public MainGame() {
        super("RayBan");
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	
    	int height = container.getHeight();
    	int width = container.getWidth();
    	
    	p = new Player(40, width/2, height, Color.cyan);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
    	
    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.drawString("RayBan", 0, 100);
        int xMove = container.getInput().getAbsoluteMouseX();
        int yMove = container.getInput().getAbsoluteMouseY();
		p.draw(g, xMove, yMove);
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