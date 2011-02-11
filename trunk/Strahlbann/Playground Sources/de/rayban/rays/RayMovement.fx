/*
 * RayMovement.fx
 *
 * Created on 12.02.2010, 20:37:02
 */

package de.rayban.rays;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

/**
 * @author Stefan
 */
def width : Integer = 480;
def heigth: Integer = 640;

var rays : Ray[];

var eventLoop = Timeline {
	repeatCount: Timeline.INDEFINITE
	keyFrames : [
            KeyFrame {
                time : 2s
                canSkip : true
                action: createRandomRay
            }
	]
}

function createRandomRay() {
    println("new ray");
    var colors = [Color.WHITE, Color.RED, Color.YELLOW];
    var random = javafx.util.Math.random() * 1000;

    var pos = -1;

    if (random mod width < width/2) {
        pos = 1;
    }

    var ray = Ray {
        color: colors[random mod 3 as Integer];
        length: random mod 150
        xDir: random mod 3 + 2 * pos
        yDir: 5
        xPosStart: random mod width as Integer
    }
    ray.move();

    insert ray into rays;
}

Stage {
    title : "Ray Movement"
    style: StageStyle.DECORATED
    scene: Scene {
        fill: LinearGradient {
	stops: [
                Stop {
                    color : Color.BLACK
                    offset: 0.0
                },
                Stop {
                    color : Color.BLUE
                    offset: 1.0
                },
            ]
        }

        width: width
        height: heigth
        content: bind rays
    }
}

eventLoop.playFromStart();

