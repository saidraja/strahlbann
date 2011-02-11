/*
 * EnemyMove.fx
 *
 * Created on 07.03.2010, 20:58:08
 */

package de.rayban.enemy;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.effect.MotionBlur;

/**
 * @author Daniel
 */
def enemy = Enemy {

}

def enemyUI : Node = enemy.enemyNode();
enemyUI.scaleX = 0.3;
enemyUI.scaleY = 0.3;
enemyUI.translateX = -200;
enemyUI.translateY = -250;

Stage {
    title: "Enemy Movement"
    scene: Scene {
        width: 700
        height: 700
        content: [
            enemyUI
        ]
        fill: Color.BLACK
    }
}

enemy.startSpriteAnimation();

Timeline {
	repeatCount: Timeline.INDEFINITE
	keyFrames : [
		KeyFrame {
                    time : 0s
                    values: [

                    ]
		},
                KeyFrame {
                    time : 10s
                    values: [
                        enemyUI.translateY => 500
                    ]
                }

	]
}.play()
