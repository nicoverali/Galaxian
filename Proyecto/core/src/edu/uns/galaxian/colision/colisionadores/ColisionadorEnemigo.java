package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;

import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEnemigo implements Colisionador<Enemigo> {

	private Enemigo objetoFuente;

	public ColisionadorEnemigo(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getFuerzaDeColision());
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// La colision entre enemigos no produce ningun efecto.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}
	
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// Un disparo enemigo no afecta al enemigo.
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		obstaculo.restarVida(objetoFuente.getFuerzaDeColision());
	}
}
