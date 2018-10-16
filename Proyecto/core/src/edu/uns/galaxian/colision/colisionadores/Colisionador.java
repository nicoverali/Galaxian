package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public interface Colisionador<T> {

	/**
	 * Comportamiento al momento de colisionar con un Jugador
	 * @param jugador Jugador con el que se colisiono
	 */
	void colisionarConJugador(Jugador jugador);

	/**
	 * Comportamiento al momento de colisionar con un Enemigo
	 * @param enemigo Enemigo con el que se colisiono
	 */
	void colisionarConEnemigo(Enemigo enemigo);

	/**
	 * Comportamiento al momento de colisionar con un Disparo
	 * @param disparo Disparo con el que se colisiono
	 */
	void colisionarConDisparoJugador(DisparoJugador disparo);
	
	/**
	 * Comportamiento al momento de colisionar con un Disparo
	 * @param disparo Disparo con el que se colisiono
	 */
	void colisionarConDisparoEnemigo(DisparoEnemigo disparo);
	
	/**
	 * Comportamiento al momento de colisionar con un Obstaculo
	 * @param obstaculo Obstaculo con el que se colisiono
	 */
	void colisionarConObstaculo(Obstaculo obstaculo);
}