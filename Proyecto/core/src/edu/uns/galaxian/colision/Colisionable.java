package edu.uns.galaxian.colision;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.hitbox.HitBox;

public interface Colisionable {

	/**
	 * Retorna el hitbox del colisionable
	 * @return Hitbox del colisionable
	 */
	HitBox getHitBox();

	/**
	 * Devuelve el colisionador del colisionable
	 * @return Colisionador del colisionable
	 */
	Visitor getColisionador();

	/**
	 * El objeto colisionable acepta entrar en un estado de colision. Recibe
	 * el colisionador del otro colisionable para indicarle que accion realizar.
	 * @param colisionador Colisionador del otro colisionable participante en la colision producida
	 */
	void aceptarVisitor(Visitor colisionador);
	
}