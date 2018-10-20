package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;
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
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		//No pasa nada
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		//No pasa nada
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		//No pasa nada		
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		//No pasa nada
	}
	
	public void colisionarConPowerUp(PowerUp powerUp) {
		
	}

}
