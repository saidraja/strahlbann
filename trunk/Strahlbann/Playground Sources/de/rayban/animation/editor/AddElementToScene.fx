package de.rayban.animation.editor;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * Test zum Prüfen ob es möglich ist einfach neue Elemente in
 * eine Szene zu packen. Button fügt ein neues Rechteck ein.
 *
 * @author Daniel
 */


var contentOffset : Number = 5.0;

var scene2 : Scene = Scene {
        width: 400
        height: 200
        content: [
           Button {
            text: "Button"
            action: function() {
                var rec = Rectangle {
                x: 10, y: 10
                width: 90, height: 90
                fill: Color.RED
                }
                rec.translateX = contentOffset;
                rec.translateY = contentOffset;
                insert rec into scene2.content;
                contentOffset += 5;
            }
            }
        ]
}

Stage {
    title: "MyApp"
    scene: scene2
}
