package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEnemigo extends Colisionador<Enemigo> {

	private Enemigo objetoFuente;

	public ColisionadorEnemigo(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void visitJugador(Jugador jugador) {
		objetoFuente.restarVida(40);
	}

	public void visitDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
		if(objetoFuente.getVida().getValor()<=0) {
			disparo.sumarPuntajeJugador(objetoFuente.getBonus());
		}
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void visitEscudo(Escudo escudo) {
		objetoFuente.restarVida(objetoFuente.getVida().getValor());
	}

	public void visitBarricada(Barricada obstaculoEnemigo) {
		objetoFuente.restarVida(obstaculoEnemigo.getFuerzaDeColision());
	}
	
}
