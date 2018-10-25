package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

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
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// Un enemigo no afecta a un powerUp.
	}
}
