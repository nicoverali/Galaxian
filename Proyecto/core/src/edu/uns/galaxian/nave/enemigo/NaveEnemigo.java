package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.nave.Nave;

public abstract class NaveEnemigo extends Nave {

	/**
	 * Retorna el dano de colision.
	 * @return Dano de colision de la nave
	 */
	public abstract int getDamage();

	/**
	 * Retorna la inteligencia de ataque de la nave.
	 * @return Inteligencia de ataque la nave
	 */
	public abstract InteligenciaArtificial getInteligenciaDeAtaque();

}
