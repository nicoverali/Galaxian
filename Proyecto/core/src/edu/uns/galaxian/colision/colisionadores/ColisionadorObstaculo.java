package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;

public class ColisionadorObstaculo extends Colisionador<Obstaculo> {
	
	protected Obstaculo objetoFuente;
	
	public ColisionadorObstaculo(Obstaculo obstaculo) {
		objetoFuente = obstaculo;
	}

	public void visitEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getFuerzaDeColision());
	}

	public void visitDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void visitBarricada(Barricada barricada) {
		objetoFuente.restarVida(barricada.getFuerzaDeColision());
	}

}