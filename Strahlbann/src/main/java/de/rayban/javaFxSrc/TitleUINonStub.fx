/*
 * TitleUINonStub.fx
 *
 * Created on 16.03.2010, 07:46:26
 */
package de.rayban.ui;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;
import de.rayban.RayBanStage;
import javafx.scene.CustomNode;
import javafx.scene.Node;

/**
 * Bringt Leben in den Stub des Importierten SVGs.
 *
 * Gewissermaßen ist dies ein Pattern im Umgang mit FXZs und FXDs.
 *
 * @author Daniel
 */
public class TitleUINonStub extends CustomNode {
    def ui = TitleUI {};

    // Holen wir uns das Element aus dem FXZ welches wir manipulieren wollen.
    def newGame = ui.getNode("newGame");

    // Manipulation des Elements im Konstruktor
    init {
        newGame.onMouseEntered = function (e: MouseEvent): Void {
            newGameTimeLine.play();
        };
        newGame.onMouseExited = function (e: MouseEvent): Void {
            newGameTimeLine.stop();
        };
        newGame.onMousePressed = function (e: MouseEvent): Void {
            RayBanStage.get().switchScene("Go");
        }
    }

    // Hier geben wir ganz blöd nur den UIStub zurück
    override protected function create () : Node {
        return ui;
    }

    // Ein wenig Animation für den Button
    var newGameTimeLine = Timeline {
                repeatCount: Timeline.INDEFINITE
                keyFrames: [
                    KeyFrame {
                        time: 0s
                        canSkip: true
                        values: [
                                newGame.scaleX => 1.0 tween Interpolator.LINEAR,
                                newGame.scaleY => 1.0 tween Interpolator.LINEAR
                        ]
                    },
                    KeyFrame {
                        time: 0.5s
                        values: [
                                newGame.scaleX => 0.7 tween Interpolator.LINEAR,
                                newGame.scaleY => 0.7 tween Interpolator.LINEAR
                        ]
                    },
                    KeyFrame {
                        time: 1.0s
                        values: [
                                newGame.scaleX => 1.0 tween Interpolator.LINEAR,
                                newGame.scaleY => 1.0 tween Interpolator.LINEAR
                        ]
                    }
                ]
            }
}
