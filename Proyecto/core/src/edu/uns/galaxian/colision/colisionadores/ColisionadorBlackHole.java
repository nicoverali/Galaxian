package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class ColisionadorBlackHole extends ColisionadorObstaculo {

	public ColisionadorBlackHole(Obstaculo obstaculo) {
		super(obstaculo);
	}

	// TODO los siguientes métodos deberian setear una inteligencia que los guie al centro del agujero negro.
	
	public void visitEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getFuerzaDeColision());
	}
	
	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void visitBarricada(Barricada barricada) {
		objetoFuente.restarVida(barricada.getFuerzaDeColision());
	}

}