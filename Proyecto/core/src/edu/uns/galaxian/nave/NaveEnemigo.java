package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;

public interface NaveEnemigo extends Nave {

	/**
	 * Retorna el daño de colision
	 */
	public int getDamage();
	/**
	 * Retorna la inteligencia del enemigo
	 */
	public InteligenciaArtificial getInteligencia();
	
	/**
	 * Setea la inteligencia al enemigo
	 */
	public void setInteligencia(InteligenciaArtificial i);
}
