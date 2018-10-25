package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorJugador extends ColisionadorNulo<Jugador> {
	
	private Jugador objetoFuente;

	public ColisionadorJugador(Jugador objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getFuerzaDeColision());
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}
	
}
