package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;

import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorJugador implements Colisionador<Jugador> {
	
	private Jugador objetoFuente;

	public ColisionadorJugador(Jugador objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		// Un jugador no afecta a otro jugador.
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getFuerzaDeColision());
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// Un disparo del jugador no afecta al mismo.
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// El jugador no es el encargado de obtener el beneficio del powerUp.
	}
	
}
