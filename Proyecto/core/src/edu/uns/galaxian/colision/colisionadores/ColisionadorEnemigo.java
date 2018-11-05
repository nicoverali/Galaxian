package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEnemigo extends ColisionadorAdapter<Enemigo> {

	private Enemigo objetoFuente;

	public ColisionadorEnemigo(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		objetoFuente.restarVida(40);
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void colisionarConEscudo(Escudo escudo) {
		objetoFuente.restarVida(objetoFuente.getVida().getValor());
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		objetoFuente.restarVida(obstaculoEnemigo.getFuerzaDeColision());
	}
	
}
