package edu.uns.galaxian.colision;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.status.GameObject;

public interface Colisionable {

	/**
	 * Devuelve el alto del colisionable
	 * @return Alto del colisionable
	 */
	float getAlto();

	/**
	 * Devuelve el ancho del colisionable
	 * @return Ancho del colisionable
	 */
	float getAncho();

	/**
	 * Devuelve el status del colisionable
	 * @return GameObject del colisionable
	 */
	GameObject getStatus();

	/**
	 * El objeto colisionable acepta entrar en un estado de colision. Recibe
	 * el colisionador del otro colisionable para indicarle que accion realizar.
	 * @param colisionador Colisionador del otro colisionable participante en la colision producida
	 */
	void aceptarColision(Colisionador colisionador);

	/**
	 * Devuelve el colisionador del colisionable
	 * @return Colisionador del colisionable
	 */
	Colisionador getColisionador();
	
	HeadBox getHeadBox();
	
	boolean aceptarInterseccion(HeadBox headBox);
}
