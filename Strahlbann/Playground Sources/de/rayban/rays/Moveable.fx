/*
 * Moveable.fx
 *
 * Created on 12.02.2010, 20:48:40
 */

package de.rayban.rays;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.CustomNode;

/**
 * @author Stefan
 */

public abstract class Moveable extends CustomNode {
    protected var animation = Timeline {
	repeatCount: Timeline.INDEFINITE
	keyFrames : [
                KeyFrame {
                    time : 30ms
                    canSkip : true
                    action: moveStep
                }
            ]
    }

    public function move() {
        animation.playFromStart();
    }

    protected abstract function moveStep() : Void;
}
