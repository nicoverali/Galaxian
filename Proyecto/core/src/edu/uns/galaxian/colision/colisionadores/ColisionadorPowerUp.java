package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorPowerUp implements Colisionador<PowerUp> {

	private PowerUp objetoFuente;

	public ColisionadorPowerUp(PowerUp powerUp){
		this.objetoFuente=powerUp;
	}
	
	public void colisionarConJugador(Jugador jugador) {
		objetoFuente.efectoJugador(jugador);
		objetoFuente.eliminar();
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// Un powerUp no beneficia a un enemigo.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// Un disparo no afecta al powerUp.
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// Un disparo no afecta al powerUp.
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		// Un obstaculo no afecta al powerUp.
	}
	
	public void colisionarConPowerUp(PowerUp powerUp) {
		// Un powerUp no afecta a otro.
	}

}
