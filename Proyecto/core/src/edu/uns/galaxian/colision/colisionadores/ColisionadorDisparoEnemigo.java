package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo implements Colisionador<DisparoEnemigo> {

	private DisparoEnemigo objetoFuente;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		objetoFuente.eliminar();
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// Un disparo enemigo no afecta a un enemigo.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// Un disparo enemigo no afecta a un disparo jugador.
	}
	
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// Un disparo enemigo no afecta a otro disparo enemigo.
	}
  
	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.eliminar();
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// El disparo no afecta a un powerUp
	}
}
