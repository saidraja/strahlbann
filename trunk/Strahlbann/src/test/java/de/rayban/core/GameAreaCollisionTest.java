package de.rayban.core;

import org.junit.Test;
import org.mockito.Mockito;
import org.newdawn.slick.geom.Rectangle;


public class GameAreaCollisionTest {
	@Test
	public void testCalcCollisionVector(){
		final GameArea collisionArea = new GameArea(new Rectangle(30, 10, 40, 200));
		final GameAreaAware gameAreaAware = Mockito.mock(GameAreaAware.class);
		final Rectangle rec = new Rectangle(0, 0, 10, 10);
		Mockito.when(gameAreaAware.collisionShape()).thenReturn(rec);
		collisionArea.calcCollisionVector(gameAreaAware);
	}
}
