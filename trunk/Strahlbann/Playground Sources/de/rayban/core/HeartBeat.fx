package de.rayban.core;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;


/**
 * @author Daniel
 */
 
public class HeartBeat 
{

public var instrumented : IHaveRythm [];

// der Herzschlag
var heartBeatLine = Timeline {
    repeatCount: Timeline.INDEFINITE,
    keyFrames: [
        KeyFrame {
            time: 300ms,
            canSkip: true
            action :  
            function() {
            	for(i in instrumented){
            	    i.clap();
            	}
            }
        }
    ]
}

public function life() {
    heartBeatLine.play();
}

public function die() {
    heartBeatLine.stop();
}

}
