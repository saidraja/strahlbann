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

/**
 * @author Daniel
 */

def mouseMove = function (e : MouseEvent){
    player.centerX = e.sceneX;
    // lässt sich nicht zuweisen. onMouseMoved erwartet eine Void - Methode
};

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
	startX: bind player.centerX, startY: bind player.centerY
	endX: 40, endY: 40
	strokeWidth: 2
	stroke: Color.BLACK
}

var eventSinkMovePlayer : Rectangle = Rectangle {
	x: 0, y: sceneHeight - eventSinkMovePlayerHeight
	width: sceneWidth, height: eventSinkMovePlayerHeight
	fill: Color.TRANSPARENT
         onMouseMoved: function (e : MouseEvent){
            player.centerX = e.sceneX;
        }
}

var eventSinkAdjustRay : Rectangle = Rectangle {
	x: 0, y: 0
	width: sceneWidth, height: sceneWidth - eventSinkMovePlayerHeight
	fill: Color.TRANSPARENT
         onMouseMoved: function (e : MouseEvent){
            ray.endX = e.sceneX;
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
                content: "Testet die Funktionsweise der Spielersteuerung, hier getrennte \nBewegung von Spieler und Strahl"
            },
            player, ray, eventSinkMovePlayer, eventSinkAdjustRay
        ]
    }
}