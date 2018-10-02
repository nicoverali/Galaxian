package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.status.Status;

public interface Colisionable {

	/**
	 * Devuelve el alto del colisionable
	 * @return Alto del colisionable
	 */
	public float getAlto();

	/**
	 * Devuelve el ancho del colisionable
	 * @return Ancho del colisionable
	 */
	public float getAncho();

	/**
	 * Devuelve el status del colisionable
	 * @return Status del colisionable
	 */
	public Status getStatus();

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
