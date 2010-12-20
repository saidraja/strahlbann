/*
 * SvgFontRenderer.fx
 *
 * Created on 18.03.2010, 07:33:40
 */

package de.rayban.ui;
import javafx.scene.Node;
import javafx.fxd.FXDNode;
import javafx.scene.Group;
import javafx.lang.FX;
import javafx.lang.Builtins;

/**
 * Wandelt einen String in eine Group von Nodes um die über eine
 * ID eindeutig jedem Zeichen aus dem String zugeordnet werden können.
 * Datenbasis ist ein SVG.
 *
 * @author Daniel
 */

public class SvgFont {
    // UI-Stub der alle Schriftzeichen enthält
    // id ist das Schriftzeichen selbst.
    public-init var svgFont : FXDNode;

    public var charSpacing : Number = 0.0;

    /**
     * Wandelt einen beliebigen String in eine Reihenfolge von SVG-Elementen
     * um. Der übergebenen String wird dabei in Chars zerlegt. Die Abfrage über
     * das FXDNode svgFont ist dabei case-sensitiv.
     */
    public function text(text : String) : Node{
        var resultingNodeGroup : Group = Group {};
        var translateCharX : Number = 0.0;

        for (c in text.toCharArray()) {
            var nodeChar : Node = javafx.fxd.Duplicator.duplicate(svgFont.getNode(String.valueOf(c)));
            if(nodeChar == null){
                println("Char {c} konnte nicht in ein SVG-Element gerendert werden, da das Element nicht bekannt ist.");
                continue;
            }
            println("Char {c} boundsInParent x: {nodeChar.boundsInParent.minX} y: {nodeChar.boundsInParent.minY} xMax: {nodeChar.boundsInParent.maxX} yMax: {nodeChar.boundsInParent.maxY} heightParent: {nodeChar.parent.boundsInParent.height}");

            // den Char auf der X-Achse in den Ursprung der Node verschieben
            nodeChar.translateX = -nodeChar.boundsInParent.minX;
            // in den Ursprung verschieben. Buchstabe verschwindet erstmal aus dem
            // sichtbaren Bereich.
            nodeChar.translateY = -nodeChar.boundsInParent.maxY;
            // den Char nach rechts verschieben damit keine Überschneidungen auftreten
            nodeChar.translateX = nodeChar.localToParent(translateCharX, 0).x;

            // die Breite des Chars merken um den nächsten Char entsprechend
            // nach rechts rücken zu können.
            translateCharX = nodeChar.layoutBounds.width + translateCharX + charSpacing;

            println("translateCharX = {translateCharX}");
            insert nodeChar into resultingNodeGroup.content;
        }

        // jetzt müssen wir den gesamten Schriftzug auch noch auf der y-Achse
        // in den Ursprung rücken. Dazu berechnen wir die maximale Höhe aller
        // Nodes. Diese wird dann der ursprünglichen Translation auf der y-Achse
        // zuaddiert.
        var maxNodeHeight;
        for(n in resultingNodeGroup.content) {
            if(FX.isSameObject(maxNodeHeight, null)) {
               maxNodeHeight = n.boundsInParent.height;
                continue;
            }

            if(maxNodeHeight < n.boundsInParent.height){
               maxNodeHeight = n.boundsInParent.height;
            }
        }

        // die maximale Höhe zur Translation hinzuaddieren. Somit ist der
        // Schriftzug wieder sichtbar.
        resultingNodeGroup.translateY = maxNodeHeight;

        return resultingNodeGroup;
    }
}
