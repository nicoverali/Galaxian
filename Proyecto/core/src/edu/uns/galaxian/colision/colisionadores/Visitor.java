package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public interface Visitor<T> {

	/**
	 * Comportamiento al momento de visitar un Jugador.
	 * @param jugador Jugador que se visita.
	 */
	public void visitJugador(Jugador jugador);

	/**
	 * Comportamiento al momento de visitar un Enemigo.
	 * @param enemigo Enemigo que se visita.
	 */
	public void visitEnemigo(Enemigo enemigo);

	/**
	 * Comportamiento al momento de visitar un DisparoJugador.
	 * @param disparo DisparoJugador que se visita.
	 */
	public void visitDisparoJugador(DisparoJugador disparo);
	
	/**
	 * Comportamiento al momento de visitar un DisparoEnemigo.
	 * @param disparo DisparoEnemigo que se visita.
	 */
	public void visitDisparoEnemigo(DisparoEnemigo disparo);
	
	/**
	 * Comportamiento al momento de visitar un Obstaculo.
	 * @param obstaculo Obstaculo que se visita.
	 */
	public void visitObstaculo(Obstaculo obstaculo);
	
	/**
	 * Comportamiento al momento de visitar un PowerUp.
	 * @param powerUp PowerUp que se visita.
	 */
	public void visitPowerUp(PowerUp powerUp);
	
	/**
	 * Comportamiento al momento de visitar un escudo.
	 * @param escudo Escudo que se visita.
	 */
	public void visitEscudo(Escudo escudo);
	
	/**
	 * Comportamiento al momento de visitar una Barricada.
	 * @param barricada Barricada que se visita.
	 */
	public void visitBarricada(Barricada barricada);
}