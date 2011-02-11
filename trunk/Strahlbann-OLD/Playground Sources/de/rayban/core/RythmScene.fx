package de.rayban.core;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

/**
 * @author Daniel
 */



var line = Line {
    startX: 10,
	startY: 100,
    endX: 40,
	endY: 100,
    strokeWidth: 1,
    stroke: Color.RED
}

var r : Rectangle = Rectangle {
    x: 10,
	y: 10,
    width: 50,
	height: 50,
    fill: Color.BLACK
    onMouseDragged: function( e: MouseEvent ): Void {
        r.translateX = e.sceneX;
        r.translateY = e.sceneY;
    }
}

var circle = MyCircle{
   				centerX: 100
   				centerY: 100
   				radius: 30
   				fill: Color.BLACK
   				collisionShapes : [
   					r,
   					line,
   				]
        	}

Stage {
    title : "Kollisionserkennung mit Heartbeat"
    scene: Scene {
        width: 200
        height: 200
        content: [  
        	circle,
        	line,
        	r
        ]
    }
}

var heartBeat = HeartBeat {
	instrumented : [{
		circle
	}
	]
}

heartBeat.life();

Timeline {
    repeatCount: Timeline.INDEFINITE,
    keyFrames: [
        KeyFrame {
            time: 1s,
            canSkip: true
            values : [
                line.translateX => 0.0 tween Interpolator.LINEAR
            ]
        },
        javafx.animation.KeyFrame {
        	time: 10s
        	values : [
                line.translateX => 200.0 tween Interpolator.LINEAR
            ]
        }
    ]
}.play()