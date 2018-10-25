package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
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
	
	/**
	 * Comportamiento al momento de colisionar con un PowerUp
	 * @param powerUp PowerUp con el que se colisiono
	 */
	void colisionarConPowerUp(PowerUp powerUp);
}