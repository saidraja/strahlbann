package de.rayban.svg;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.InkscapeLoader;
import org.newdawn.slick.svg.SimpleDiagramRenderer;

public class SvgFont extends BasicGame {
	Diagram d;
	
	public SvgFont(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		d = InkscapeLoader.load("de\\rayban\\svg\\svgfont.svg");
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		SimpleDiagramRenderer.render(g, d);
	}

	public static void main(String [] argv) throws SlickException{
		AppGameContainer agc = new AppGameContainer(new SvgFont("SvgFont"));
		agc.start();
	}
}
