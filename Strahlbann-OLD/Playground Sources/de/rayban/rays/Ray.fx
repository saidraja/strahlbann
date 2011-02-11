/*
 * Ray.fx
 *
 * Created on 12.02.2010, 20:42:40
 */
package de.rayban.rays;

import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * @author Stefan
 */

 def FLY : Integer = 0;
 def ABSORB : Integer = 1;
 def REFLECT : Integer = 2;
 
public class Ray extends Moveable {

    public-init var color : Color;
    public-init var length: Number;
    public-init var xPosStart : Integer;
    public-init var xDir : Number;
    public-init var yDir : Number;
    public var mode : Integer = FLY;

    var r = yDir / xDir;

    /**
    * Momentan nur Spezialfall Spiegelung an X-Achse
    */
    override protected function moveStep () : Void {
        var currentLength;
        var epsilon = 2;

        if (mode != FLY) {
            var x = java.lang.Math.pow(ray.startX - ray.endX, 2);
            var y = java.lang.Math.pow(ray.startY - ray.endY, 2);
            currentLength = java.lang.Math.sqrt(x+y);
            if (currentLength >= length and mode == REFLECT) {
                ray.translateX += xDir;
                ray.translateY += yDir;
                   mode = FLY;
            }
        }

        if (mode == ABSORB and currentLength < epsilon) {
            ray.startX = ray.endX;
            ray.startY = ray.endY;
            yDir = -yDir;
            mode = REFLECT;

        }

        if (mode == FLY) {
            ray.translateX += xDir;
            ray.translateY += yDir;
        } else if (mode == ABSORB){
            ray.startX += xDir;
            ray.startY += yDir;
        } else if (mode == REFLECT) {
            ray.endX += xDir;
            ray.endY += yDir;
        }
    }
    
    var ray = Line {
        startX: - (length / java.lang.Math.sqrt(((r * r)  + 1))) + xPosStart
        startY: - r * (length / java.lang.Math.sqrt(((r * r)  + 1)))
        endX: xPosStart,
        endY: 0
        strokeWidth: 2
        stroke: bind color
    }

    public function reflect() {
        if (mode == FLY) {
            mode = ABSORB;
        }
    }

    override protected function create () : Node {
        Group {
            content: [ray]
        }
    }
}