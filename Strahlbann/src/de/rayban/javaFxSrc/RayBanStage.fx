/*
 * RayBanStage.fx
 *
 * Klasse zeichnet sich dadurch aus, dass man leicht zwischen verschiedenen
 * Szenen wechseln kann. Das wird zum Beispiel für den Startbildschirm und
 * den Spielbildschirm benötigt.
 *
 * Created on 14.03.2010, 13:56:06
 */

package de.rayban;
import javafx.stage.Stage;
import de.rayban.RayBanScene;
import java.lang.RuntimeException;

/**
 * @author Daniel
 */

// statische Instanz der Stage. Gewährleistet Singleton-Zugriff.
var rayBanStage : RayBanStage;

public class RayBanStage extends Stage{
    var scenes : RayBanScene [];
    
    init {
        rayBanStage = this;
    }


    /**
     * Eine weitere Scene der RayBanStage hinzufügen
     */
    public function addScene(rayBanScene : RayBanScene) {
        var idCollisions = scenes[n | n.id.equals(rayBanScene.id)];
        if(sizeof idCollisions > 0) {
            throw new RuntimeException("Eine Scene mit der ID {rayBanScene.id} existiert schon");
        }

        insert rayBanScene into scenes;
    }

    /**
     * Eine Scene wechseln, sprich zur Anzeige bringen.
     */
    public function switchScene(id : String) {
            // die alte Szene entfernen und alle Animationen stoppen
            var oldScene = this.scene as RayBanScene;
            oldScene.stopAnimationOnSwitch();

            // coooool....Predicates :-)
            var scenev2 = scenes[n | n.id.equals(id)];
            this.scene = scenev2[0];
            scenev2[0].startAnimationOnInsert();
    }
}

/**
 * Singleton-Zugriff sicherstellen.
 */
public function get() : RayBanStage {
    if(FX.isInitialized(rayBanStage)){
        return rayBanStage;
    }

    return RayBanStage{};
}
