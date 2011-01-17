package de.rayban.core;

public interface Hitable {

	/** liefert die Zeitdauer bis es zum Treffer kam */
	public long livingTimeTillHit();

	/**
	 * Als getroffen markieren.
	 */
	public void hit();

	/**
	 *
	 * @return true wenn das Hitable als getroffen markiert wurde, sonst false.
	 */
	public boolean hitReceived();

	/**
	 * kann getroffen werden, ab diesem Zeitpunkt wird die Zeit gemessen bis es
	 * zum Treffer kommt
	 */
	public void readyToHit();

	/** die Punkte die es für den Treffer gibt, dynamisch berechnet */
	public long hitScore();

	/**
	 * setzt den internen Status (Score, Trefferzeiten, etc.) des Hitables
	 * zurück
	 */
	public void reset();
}
