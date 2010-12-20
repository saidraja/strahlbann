/*
 * Main.fx
 *
 * Created on 09.02.2010, 10:52:32
 */

package de.rayban;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import de.rayban.Settings;
import de.rayban.ui.TitleUINonStub;

/**
 * @author stefans
 */

var stage : RayBanStage = RayBanStage.get();
stage.title = "RayBan";
stage.addScene(RayBanScene{
    id: "Start"
    content: [
            TitleUINonStub{},
            /*
            Circle {
                centerX: 100, centerY: 100
                radius: 40
                fill: Color.BLACK
                onMousePressed: function (e: MouseEvent): Void {
                    stage.switchScene("Go");
                }
            }
            */
    ]
});

stage.addScene(RayBanScene{
    id : "Go"
    content: [
        Rectangle {
	x: 40, y: 80
	width: 140, height: 90
	fill: Color.BLACK
        onMousePressed: function (e: MouseEvent): Void {
                    stage.switchScene("Start");
                }
        },
        Text {
            font : Font {
               size: 10
            }
            x: 10, y: 30
            content: "Ein Klick auf das Rechteck wechselt die Szene."
        }

    ]
});

stage.width = Settings.STAGE_WIDTH;
stage.height = Settings.STAGE_HEIGHT;

// Eine Szene muss am Anfang gewählt sein sonst wird gar nichts angezeigt
stage.switchScene("Start");