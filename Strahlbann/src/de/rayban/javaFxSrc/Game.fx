/*
 * Game.fx
 *
 * Created on 14.03.2010, 19:53:08
 */

package de.rayban.game;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

/**
 * Singleton
 *
 * Zentrale Klasse des Spiels. Definiert die Spielmechanik (Level, Anzahl Gegner, etc.)
 * und verwaltet grundlegende Informationen wie gesammelte Punkte, Spieldauer, Level etc.
 *
 * @author Daniel
 */

// die einzige Instanz dieser Klasse
var GAME : Game;

public class Game {
    // Die Punkte die ein Spieler gesammelt hat
    public-read var score : Number;

    // Das aktuelle Level in dem sich der Spieler befindet
    public-read var level : Number;

	public-read var enemies : Enemy [];

	// Herzschlag der Spielmechanik. Im Sekundenintervall werden alle spielmechanischen
	// Berechnungen durchgeführt.
	var heartbeat : Timeline;

    init {
        GAME = this;
        reset();
    }

	/**
	 * Neues Spiel wird gewünscht.
	 */
	public function start() {
		reset();
		heartbeat.play();
	}

	/**
	 * Setzt alle spielspezifischen Werte wie Punkte, Level zurück
	 * und überführt das Singleton in seinen Urzustand.
	 */
	public function reset() {
	    score = 0;
	    level = 1;
	    heartbeat = Timeline {
	        repeatCount : Timeline.INDEFINITE;
	        keyFrames : javafx.animation.KeyFrame {
	        	time: 1s
	        	action: 
	        	function() {
	    			updateGameState();    	
	        	}
	        }
	    };
	}

	/**
	 * Stoppt das Spiel und brint das Singleton in den Urzustand zurück.
	 */
	public function stop(){
	    reset();
	    heartbeat.stop();
	}

	/**
	 * Pausiert das Spiel
	 */
	public function pause(){
	    heartbeat.pause();
	}

	/**
	 * Methode ermittelt anhand der aktuellen Situation ob der
	 * Spieler weiterspielen kann, oder das Spiel beendet ist.
	 * 
	 * @return true wenn das Spiel zu Ende ist.
	 */
	public function gameOver() : Boolean {
	    
	    return false;
	}

	/**
	 * Hier passiert alles was im Rythmus bestimmt werden muss.
	 * Z.B. wurden Gegner getroffen -> Score aktualisieren
	 * wurde eine noch nicht bestimmte Grenze erreicht -> Level wechseln
	 * 
	 * Hier dürfen keine aufwendigen Berechnungen erfolgen!
	 */
	function updateGameState() {
	    
	}
}

public function get() : Game {
    if(FX.isInitialized(GAME)) {
        return GAME;
    }

    return Game{};
}
