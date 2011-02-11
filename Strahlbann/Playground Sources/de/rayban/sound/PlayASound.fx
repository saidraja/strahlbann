package de.rayban.sound;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.TextBox;
import javafx.scene.input.MouseEvent;



/**
 * @author Daniel
 */
Stage {
    title: "Application title"
    width: 250
    height: 80
    scene: Scene {
        content: [
        	fileUri,
        	Button {
        	        	    text: "Playme"
        	        	    onMousePressed: function( e: MouseEvent ): Void {
        	        	        if(aPlayer.status == MediaPlayer.PLAYING){
        	        	            aPlayer.stop();
        	        	        }
        	        	        aSound.source = fileUri.text;
        	        	        aPlayer.play();
        	        	    }
        	        	}
        ]
        
    }
}

// hmm...wird nicht angezeigt. Warum???
def fileUri = TextBox {
        	    text: "file:///e:/jfx.mp3"
        	    selectOnFocus: true
        	    translateY : 20
        	    columns: 100
        	    visible: true
        	    width: 200
        	    height: 30
        	}

def aSound = Media {
    source: fileUri.text
}

def aPlayer = MediaPlayer {
    media: aSound
}