package de.rayban.core;

import javafx.scene.shape.Circle;

/**
 * @author Daniel
 */import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class MyCircle extends IHaveRythm, Circle {
    public var collisionShapes : Shape [];
    
    /**
     * Status Variable. True wenn eine Kollision in der laufenden Berechnung vorliegt.
     */
    var collision : Boolean = false;
    
    override function clap(){
        for(s in collisionShapes){
	        if(intersects(s.boundsInParent)){
	            fill = Color.YELLOW;
	            // merken, dass eine Kollision stattgefunden hat.
	            collision = true;
	          // nur zurücksetzen wenn noch keine Kollision vorliegt.
	        } else if(collision == false){
	            fill = Color.BLACK;
	        }
        }
        // Status wieder zurücksetzen
        collision = false;
    }
}