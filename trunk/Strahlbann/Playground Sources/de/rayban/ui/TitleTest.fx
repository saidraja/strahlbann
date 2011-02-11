/*
 * TitleTest.fx
 *
 * Created on 06.03.2010, 13:28:20
 */

package de.rayban.ui;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;

/**
 * @author Daniel
 */
def title : TitelUI = TitelUI {
}

def buttonNewGame = title.getNode("newGame");

/**
 * Seltsam, der letzte Eintrag bei KeyFrame.values überschreibt den ersten.
 * Sprich: die X-Skalierung wird im Rahmen der Animation nicht durchgeführt.
 */
var newGameTimeLine = Timeline {
	repeatCount: Timeline.INDEFINITE
	keyFrames : [
		KeyFrame {
			time : 0s
			canSkip : true
                        values: [
                            buttonNewGame.scaleX => 1.0 tween Interpolator.LINEAR,
                            buttonNewGame.scaleY => 1.0 tween Interpolator.LINEAR
                        ]

		},
                KeyFrame {
                        time: 0.5s
                        values: [
                            buttonNewGame.scaleX => 0.7 tween Interpolator.LINEAR,
                            buttonNewGame.scaleY => 0.7 tween Interpolator.LINEAR
                        ]
                },
                KeyFrame {
                        time: 1.0s
                        values: [
                            buttonNewGame.scaleX => 1.0 tween Interpolator.LINEAR,
                            buttonNewGame.scaleY => 1.0 tween Interpolator.LINEAR
                        ]
                }
	]
}

buttonNewGame.onMouseEntered = function( e: MouseEvent ):Void {
    newGameTimeLine.play();
}

buttonNewGame.onMouseExited = function( e: MouseEvent ):Void {
    newGameTimeLine.stop();
}


Stage {
    title: "Application title"
    scene: Scene {
        width: 700
        height: 400
        content: [
            title
        ]
    }
}
