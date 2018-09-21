package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public interface Colisionador<T> {

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
	 * Comportamiento al momento de colisionar con un Disparo
	 * @param disparo Disparo con el que se colisiono
	 */
	public void colisionarConDisparoJugador(DisparoJugador disparo);
	
	/**
	 * Comportamiento al momento de colisionar con un Disparo
	 * @param disparo Disparo con el que se colisiono
	 */
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo);

}