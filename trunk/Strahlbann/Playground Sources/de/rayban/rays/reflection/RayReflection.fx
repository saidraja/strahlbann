/*
 * RayReflection.fx
 *
 * Created on 17.02.2010, 00:11:20
 */

package de.rayban.rays.reflection;

import javafx.scene.paint.Color;
import de.rayban.rays.Ray;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author Stefan
 */

def width : Integer = 480;
def heigth: Integer = 640;

var barrier = Line {
      startX: 0
      endX: 480
      startY: 400
      endY: 400
      strokeWidth: 1
      stroke: Color.RED
}

var barrier2 = Line {
      startX: 150
      endX: 480
      startY: 160
      endY: 160
      strokeWidth: 1
      stroke: Color.BROWN
}

var ray = Ray {
    color: Color.BLUE
    length: 160
    xDir: 2
    yDir: 3
    xPosStart: 20
}

ray.move();

Timeline {
	repeatCount: Timeline.INDEFINITE
	keyFrames : [
            KeyFrame {
                time : 30ms
                canSkip : false
                action: function() {
                    /* Irgendwie scheint er doch de Kllision mit 
                        einem Rechteck um den Ray zu berechnen und
                        nicht mit dem Ray selbst */
                    if (ray.intersects(barrier2.boundsInParent) or
                    ray.intersects(barrier.boundsInParent) ) {
                        ray.reflect();
                    } 
                }
            }
        ]
}.play();



Stage {
    title : "Ray Reflection"
    style: StageStyle.DECORATED
    scene: Scene {
        fill: Color.WHITE
        width: width
        height: heigth
        content: [
                Text {
                font : Font {
                    size : 10
                }
                x: 220
                y: 20
                content: "Testet die Reflexion eines Strahls an einem Hindernis"
            },

                barrier, barrier2, ray]
    }
}