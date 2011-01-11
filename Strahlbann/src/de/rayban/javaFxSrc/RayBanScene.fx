/*
 * RayBanScene.fx
 *
 * Created on 14.03.2010, 13:59:01
 */

package de.rayban;
import javafx.scene.Scene;

/**
 * Jede RayBan Scene verwaltet ihre Animationen selbst. Über überschriebene Hilfsmethoden
 * kann jede Instanz steuern welche Animation gestartet werden soll.
 *
 * @author Daniel
 */

public class RayBanScene extends Scene {
    public-init var id : String;

    /**
     * Wird von konkreten Instanzen überschrieben um Animationen zu starten.
     */
    public function startAnimation() {}

    /**
     * Wie startAnimation wird allerdings automatisch aufgerufen wenn die Scene
     * der Stage hinzugefügt wird.
     */
    public function startAnimationOnInsert() {}

    public function stopAnimationOnSwitch() {}

    public function stopAnimation(){}

    public function pauseAnimation(){}
}
