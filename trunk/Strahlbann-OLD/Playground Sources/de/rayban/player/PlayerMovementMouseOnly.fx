/*
 * PlayerMovement.fx
 *
 * Created on 11.02.2010, 17:42:29
 */

package de.rayban.player;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * @author Daniel
 */
def sceneWidth : Number = 250;
def sceneHeight : Number = 250;

def eventSinkMovePlayerHeight = 50;

// die Spielerfigur
var player : Circle = Circle {
	centerX: sceneWidth / 2, centerY: sceneHeight
	radius: 20
	fill: Color.BLACK
}

var ray : Line = Line {
	startX: sceneWidth / 2
	startY: 150
	endX: player.centerX
	endY: player.centerY
	strokeWidth: 2
	stroke: Color.BLACK
}

var eventSink : Rectangle = Rectangle {
	x: 0, y: 0
	width: sceneWidth, height: sceneHeight
	fill: Color.TRANSPARENT
	onMouseMoved: function (e : MouseEvent){
	    // Transformationen des Strahls
	    ray.transforms = [
	    // erst in die Ausgangsposition verschieben
	    Translate {
			x: - sceneWidth / 2
   		    y: 0.0
   		},
   		// von dort können wir die eigentliche Bewegungstransformation vornehmen
   		// die richtet sich nach der Spielfigur
	    Translate {
	        x: e.sceneX,
	        y: 0.0
	    },
	    Rotate {
	        pivotX: ray.endX,
	        pivotY: ray.endY,
	        // 180 / sceneHeight : Verhältnis maximaler Winkel zu Fensterhöhe berechnen
	        // * e.sceneY : absoluter Winkel auf Basis der Y-Position der Maus berechnen
	        // 90 - : da der Strahl schon quasi um 90 Grag gedreht ist muss er auch zurückgreht werden
	        // können. Das wird erreicht in dem wir einen negativen Winkel angeben.
	        // angle kann also Werte von -90 bis +90 Grad annehmen. 
	        angle: 90 - (180 / sceneHeight) * e.sceneY
	    }
	    ];
	    
	    // Transformation der Spielfigur
	   	player.transforms = [
	   	// erst in die Ausgangsposition verschieben
	   	Translate {
			x: - sceneWidth / 2
   		   	y: 0.0
   		},
   		// und dann wie gewünscht bewegen.
   		Translate {
   		    x: e.sceneX
   		    y: 0.0
   		}
   		    	    ]
	}
}


Stage {
    title: "Player Movement Test"
    scene: Scene {
        width: sceneWidth
        height: sceneHeight
        content: [
            Text {
                font : Font {
                    size : 8
                }
                x: 5
                y: 20
                content: "Testet die Funktionsweise der Spielersteuerung, hier kombinierte \nBewegung von Spieler und Strahl"
            },
            player, ray, eventSink
        ]
    }
}