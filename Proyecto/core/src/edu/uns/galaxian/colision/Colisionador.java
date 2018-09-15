package edu.uns.galaxian.colision;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public interface Colisionador {

	/**
	 * Comportamiento al momento de colisionar con un Jugador
	 * @param jugador Jugador con el que se colisiono
	 */
	public void colisionarConJugador(Jugador jugador);

	/**
	 * Comportamiento al momento de colisionar con un Enemigo
	 * @param enemigo Enemigo con el que se colisiono
	 */
	public void colisionarConEnemigo(Enemigo enemigo);

	/**
	 * Comportamiento al momento de colisionar con un DisparoJugador
	 * @param disparo DisparoJugador con el que se colisiono
	 */
	public void colisionadrConDisparoJugador(DisparoJugador disparo);

	/**
	 * Comportamiento al momento de colisionar con un DisparoEnemigo
	 * @param disparo DisparoEnemigo con el que se colisiono
	 */
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo);
}
