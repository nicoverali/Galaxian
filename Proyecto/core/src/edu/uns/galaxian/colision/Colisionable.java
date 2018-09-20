package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;

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
	 * El objeto colisionable acepta entrar en un estado de colision. Recibe
	 * el colisionador del otro colisionable para indicarle que accion realizar.
	 * @param colisionador Colisionador del otro colisionable participante en la colision producida
	 */
	public void aceptarColision(Colisionador colisionador);

	/**
	 * Devuelve el colisionador del colisionable
	 * @return Colisionador del colisionable
	 */
	public Colisionador getColisionador();
}
