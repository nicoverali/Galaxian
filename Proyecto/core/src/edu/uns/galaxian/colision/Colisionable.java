package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;

public interface Colisionable {

	/**
	 * Devuelve el alto del colisionable
	 * @return Alto del colisionable
	 */
	public int getAlto();

	/**
	 * Devuelve el ancho del colisionable
	 * @return Ancho del colisionable
	 */
	public int getAncho();

	/**
	 * Devuelve la posicion del colisionable
	 * @return Posicion del colisionable
	 */
	public Vector2 getPosicion();

	/**
	 * Devuelve el colisionador del colisionable
	 * @return Colisionador del colisionable
	 */
	public Colisionador getColisionador();
}
