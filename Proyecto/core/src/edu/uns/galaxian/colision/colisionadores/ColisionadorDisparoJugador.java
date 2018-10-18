package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;

import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoJugador implements Colisionador<DisparoJugador> {

	private DisparoJugador objetoFuente;
	
	public ColisionadorDisparoJugador(DisparoJugador objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.eliminar();
	}

	public void colisionarConJugador(Jugador jugador) {
		// Un disparo producido por el Jugador no afecta a este.
	}
	
	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// Un disparoJugador no afecta a otro disparoJugador.
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo enemigo) {
		// Un disparoJugador no afecta a un disparoEnemigo. Por el momento.
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		obstaculo.restarVida(objetoFuente.getFuerzaDeDisparo());
		objetoFuente.eliminar();
	}
}
