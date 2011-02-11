/*
 * SvgFontTest.fx
 *
 * Created on 18.03.2010, 08:01:18
 */

package de.rayban.ui;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;



/**
 * @author Daniel
 */

def svgFont : SvgFont = SvgFont {
    svgFont: AbcUI {};
    charSpacing: 20;
}


var text = svgFont.text("aababcacddee");
text.translateX = 10;
text.translateY = 100;
Stage {
    title: "SvgFontTest"
    scene: Scene {
        width: 500
        height: 200
        content: [
           text
        ]
    }
}