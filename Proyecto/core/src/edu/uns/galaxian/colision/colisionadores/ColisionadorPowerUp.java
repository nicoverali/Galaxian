package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorPowerUp extends ColisionadorNulo<PowerUp> {

	private PowerUp objetoFuente;

	public ColisionadorPowerUp(PowerUp powerUp){
		this.objetoFuente=powerUp;
	}
	
	public void colisionarConJugador(Jugador jugador) {
		objetoFuente.efectoJugador(jugador);
		objetoFuente.eliminar();
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// TODO Decidir si un disparo jugador va a afectar al powerUp.
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// TODO Decidir si un disparo enemigo va a afectar al powerUp.
	}

}
