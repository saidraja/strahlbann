/*
 * Enemy.fx
 *
 * Created on 07.03.2010, 21:00:14
 */

package de.rayban.enemy;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;

/**
 * Wrapper-Klasse. Hält den UI-Stub des Enemies und alle Animationen.
 *
 * @author Daniel
 */

public class Enemy {
    def enemyUIStub : EnemyUI = EnemyUI{}

    // Maximale Translation des UI-Elements auf der X-Achse
    def parentMaxXTranslation : Number = 50;

    // Alle Child-Elemente werden um diesen Betrag weniger auf der X-Achse transformiert
    def childXTranslationSuspension : Number = 10;

    // Alle KeyFrames der Animation werden nach Ablauf einer Sekunde abgespielt.
    // mit diesem Wert kann die Animation verschnellert oder verlangsamt werden.
    def keyFrameTimeModifier : Number = 0.3;

    def animationInterpolator : Interpolator = Interpolator.LINEAR;

    // Die Animation des Enemys. Damit sind keine Transformationen in der Stage
    // gemeint, sondern alle Animationen der Elementes des UI-Stubs
    var spriteAnimation : Timeline;

    init {
        spriteAnimation = Timeline {

            repeatCount: Timeline.INDEFINITE
            keyFrames: [
                KeyFrame {
                    time: 0s
                    values: [
                        enemyUIStub.head.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child1.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child2.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child3.translateX => 0.0 tween animationInterpolator,
                    ]
                },
                KeyFrame {
                    time: 1s * keyFrameTimeModifier
                    values: [
                        enemyUIStub.head.translateX => parentMaxXTranslation  tween animationInterpolator,
                        enemyUIStub.child1.translateX => parentMaxXTranslation - childXTranslationSuspension  tween animationInterpolator,
                        enemyUIStub.child2.translateX => parentMaxXTranslation - childXTranslationSuspension * 2  tween animationInterpolator,
                        enemyUIStub.child3.translateX => parentMaxXTranslation - childXTranslationSuspension * 3 tween animationInterpolator,
                    ]
                },
                KeyFrame {
                    time: 2s * keyFrameTimeModifier
                    values: [
                        enemyUIStub.head.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child1.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child2.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child3.translateX => 0.0 tween animationInterpolator,
                    ]
                },
                KeyFrame {
                    time: 3s * keyFrameTimeModifier
                    values: [
                        enemyUIStub.head.translateX => -1 * parentMaxXTranslation tween animationInterpolator,
                        enemyUIStub.child1.translateX => -1 * (parentMaxXTranslation - childXTranslationSuspension) tween animationInterpolator,
                        enemyUIStub.child2.translateX => -1 * (parentMaxXTranslation - childXTranslationSuspension * 2) tween animationInterpolator,
                        enemyUIStub.child3.translateX => -1 * (parentMaxXTranslation - childXTranslationSuspension * 3) tween animationInterpolator,
                    ]
                },
                KeyFrame {
                    time: 4s * keyFrameTimeModifier
                    values: [
                        enemyUIStub.head.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child1.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child2.translateX => 0.0 tween animationInterpolator,
                        enemyUIStub.child3.translateX => 0.0 tween animationInterpolator,
                    ]
                }

            ]
        }

    }

    public function startSpriteAnimation() {
        spriteAnimation.play();
    }

    public function stopSpriteAnimation(){
        spriteAnimation.stop();
    }

    // Liefert das grafische Element des Feindes
    public function enemyNode() : EnemyUI {
        return enemyUIStub;
    }

}
