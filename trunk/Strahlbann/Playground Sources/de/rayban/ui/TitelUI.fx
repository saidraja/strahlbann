/*
 * Generated by JavaFX Production Suite NetBeans plugin.
 * TitelUI.fx
 *
 * Created on Sat Mar 06 13:25:35 CET 2010
 */
package de.rayban.ui;

import java.lang.*;
import javafx.scene.Node;
import javafx.fxd.FXDNode;

public class TitelUI extends FXDNode {
	
	override public var url = "{__DIR__}RayBan-Titel.fxz";
	
	public-read protected var newGame: Node;
	public-read protected var title: Node;
	
	override protected function contentLoaded() : Void {
		newGame=getNode("newGame");
		title=getNode("title");
	}
	
	/**
	 * Check if some element with given id exists and write 
	 * a warning if the element could not be found.
	 * The whole method can be removed if such warning is not required.
	 */
	protected override function getObject( id:String) : Object {
		var obj = super.getObject(id);
		if ( obj == null) {
			System.err.println("WARNING: Element with id {id} not found in {url}");
		}
		return obj;
	}
}

