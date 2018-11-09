package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorObstaculo extends Colisionador<Obstaculo> {
	
	protected Obstaculo objetoFuente;
	
	public ColisionadorObstaculo(Obstaculo obstaculo) {
		objetoFuente = obstaculo;
	}

	public void visitJugador(Jugador jugador) {
		// TODO Falta ver si el obstaculo va a restarse vida.
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

	public void visitEscudo(Escudo escudo) {
		// TODO Falta ver si el escudo afecta a un obstaculo.
	}
	
	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void visitBarricada(Barricada obstaculoEnemigo) {
		objetoFuente.restarVida(obstaculoEnemigo.getFuerzaDeColision());
	}

}