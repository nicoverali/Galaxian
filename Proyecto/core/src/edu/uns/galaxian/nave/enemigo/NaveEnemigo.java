package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.nave.Nave;

public interface NaveEnemigo extends Nave {

	/**
	 * Retorna el dano de colision.
	 * @return Dano de colision de la nave
	 */
	public int getDamage();

	/**
	 * Retorna la inteligencia de la nave.
	 * @return Inteligencia de la nave
	 */
	public InteligenciaArtificial getInteligencia();

}
