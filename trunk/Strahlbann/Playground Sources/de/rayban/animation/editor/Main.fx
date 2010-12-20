package de.rayban.animation.editor;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Stack;
import javafx.scene.layout.Panel;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * @author Daniel
 */
Stage {
    title : "MyApp"
    width: 400
    height: 200
    scene:Scene {
	content: [
        Panel {
            maxWidth: function () : Float{
                return 100
            }

            content: [
            Circle {
                    centerX: 300, centerY: 100
                    radius: 40
                    fill: Color.BLACK
            }
            ]
        },
        Panel {
           content: [
           Rectangle {
                    x: 0, y: 0
                    width: 140, height: 90
                    fill: Color.BLACK
            }
            ]
            translateX: 200
        }
        ]
    }
}