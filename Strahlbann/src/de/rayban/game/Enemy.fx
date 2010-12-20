package de.rayban.game;

import javafx.scene.paint.Color;


/**
 * Simpler Data-Holder f�r die Feinde zur Verwendung
 * innerhalb der Spielmechanik.
 * 
 * Bindeglied zwischen GUI und Spielmechanik.
 * 
 * @author Daniel
 */
public class Enemy {
    // zerst�rt oder nicht
    var destroyed : Boolean;
    
    // Farbzugeh�rigkeit
    public-init var color : Color;
    
    public function gotYa() {
        destroyed = true;
    }
}