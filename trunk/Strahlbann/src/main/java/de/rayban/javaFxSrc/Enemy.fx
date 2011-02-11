package de.rayban.game;

import javafx.scene.paint.Color;


/**
 * Simpler Data-Holder für die Feinde zur Verwendung
 * innerhalb der Spielmechanik.
 * 
 * Bindeglied zwischen GUI und Spielmechanik.
 * 
 * @author Daniel
 */
public class Enemy {
    // zerstört oder nicht
    var destroyed : Boolean;
    
    // Farbzugehörigkeit
    public-init var color : Color;
    
    public function gotYa() {
        destroyed = true;
    }
}