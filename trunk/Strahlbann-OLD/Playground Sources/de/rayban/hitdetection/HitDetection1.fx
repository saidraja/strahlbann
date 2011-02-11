/*
 * HitDetection1.fx
 *
 * Created on 04.04.2010, 00:13:00
 */
package de.rayban.hitdetection;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Bounds;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @author Stefan
 */
var ray : Line = Line {
            startX: 25, startY: 25
            endX: 100, endY: 150
            strokeWidth: 3
            stroke: Color.BLACK
            onMouseDragged: function (e: MouseEvent): Void {
                ray.translateX = e.sceneX;
                ray.translateY = e.sceneY;
            }
        }

var barrier = Line {
      startX: 0
      endX: 200
      startY: 200
      endY: 200
      strokeWidth: 2
      stroke: Color.GREEN
}
        
var bg = Rectangle {
            x: 0, y: 0
            width: 300, height: 400
            fill: Color.WHITE
        }

var bounds : Bounds = bind ray.boundsInParent;

var boundVisualize : Rectangle = Rectangle {
	x: bind bounds.minX, y: bind bounds.minY
	width: bind bounds.width, height: bind bounds.height
        strokeWidth: 1
        stroke: Color.BLACK
        strokeDashArray: [10,10]
        fill: Color.WHITE
}



/**
 * 
* Hier brauchen wir eine andere Methode zur Kollisionserkennung.
* Die intersects arbeitet mit den bounds um das Objekt, das ist
* allerdings bei schräg im Raum liegenden Strahlen nicht gut :(
*/
function checkCollision(): Void {
    var sceneStartXRay = ray.localToScene(ray.startX, 1).x;
    var sceneEndXRay = ray.localToScene(ray.endX, 1).x;
    var sceneStartYRay = ray.localToScene(1, ray.startY).y;
    var sceneEndYRay = ray.localToScene(1, ray.endY).y;
    
    var steigungRay = (sceneEndYRay - sceneStartYRay) / (sceneEndXRay - sceneStartXRay);
    var achsabstandRay = sceneStartYRay - steigungRay * sceneStartXRay;
    
    var steigungBarrier = (barrier.endY - barrier.startY) / (barrier.endX - barrier.startX);
    var achsabstandBarrier = barrier.startY - steigungBarrier * barrier.startX;
    
    //println("{steigungRay}, {achsabstandRay}, {steigungBarrier}, {achsabstandBarrier}");
    var hit : Boolean = false;
    for(i in [barrier.startX .. barrier.endX]){
        // Differenz der y-Werte beider Geraden bestimmen
        // HINWEIS: sehr interessant ist, dass der Wert hier sich ändert wenn man die Klammern weglässt!
        // Eigentlich sollte dann trotzdem der selbe Wert rauskommen. Bug im JFX-Compiler?
        var diff = (steigungRay*i+achsabstandRay) - (steigungBarrier*i+achsabstandBarrier);
        var diff2 = steigungRay*i+achsabstandRay - steigungBarrier*i+achsabstandBarrier;
        if (diff != diff2){
            println("!!!!!!!!!!!!!{diff} != {diff2}!!!!!!!!!!!!!!!!");
        }
        
        // wenn die Differenz entsprechend klein ist, ist davon auszugehen, dass ein Schnittpunkt
        // vorliegt.
        if(diff < 5.5 and diff > -5.5){
                hit = true;
                break;
            }
    }
    
    for(i in [sceneStartXRay .. sceneEndXRay]){
        // Differenz der y-Werte beider Geraden bestimmen
                // HINWEIS: sehr interessant ist, dass der Wert hier sich ändert wenn man die Klammern weglässt!
                // Eigentlich sollte dann trotzdem der selbe Wert rauskommen. Bug im JFX-Compiler?
                var diff = (steigungRay*i+achsabstandRay) - (steigungBarrier*i+achsabstandBarrier);
                
                // wenn die Differenz entsprechend klein ist, ist davon auszugehen, dass ein Schnittpunkt
                // vorliegt.
                if(diff < 5.5 and diff > -5.5 and hit == true){
                        bg.fill = Color.RED;
                        break;
                    } else {
                        bg.fill = Color.WHITE;
                    }
    }
    
    //var yDirectionHit : Boolean = sceneStartYRay <= barrier.startY and sceneEndYRay >= barrier.endY;
    //if((sceneEndXRay <= barrier.endX and sceneStartXRay < barrier.startX and yDirectionHit)
    	//or (sceneStartXRay >= barrier.startX and sceneEndXRay <= barrier.endX and yDirectionHit)
    	//or (sceneStartXRay >= barrier.endX and sceneEndXRay <= barrier.endX and yDirectionHit)){
        //bg.fill = Color.RED;
    //} else {
      //  bg.fill = Color.WHITE;
    //}
        
    //if (barrier.intersects(ray.boundsInParent)) {
      //  bg.fill = Color.RED;
    //} else {
        //bg.fill = Color.WHITE;
    //}
}
Stage {
    title: "HitDetection"
    scene: Scene {
        width: 300
        height: 400
        content: [bg, barrier, boundVisualize, ray,
        Text {
                font : Font {
                    size : 10
                }
                x: 5
                y: 380
                content: "Hit Detection Problematik mit Bounds des Objektes"
            }]
    }
}
Timeline {
    repeatCount: Timeline.INDEFINITE
    keyFrames: [
        KeyFrame {
            time: 100ms
            canSkip: true
            action: checkCollision
        }
    ]
}.playFromStart();

