package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

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
		// Un disparoJugador no afecta a un disparoEnemigo.
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.eliminar();
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// El disparo no afecta al powerUp.
	}
}
