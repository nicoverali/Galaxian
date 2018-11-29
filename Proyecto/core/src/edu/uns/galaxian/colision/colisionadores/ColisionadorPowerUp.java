package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorPowerUp extends Colisionador<PowerUp> {

	private PowerUp objetoFuente;

	public ColisionadorPowerUp(PowerUp powerUp){
		this.objetoFuente=powerUp;
	}
	
	public void visitJugador(Jugador jugador) {
		objetoFuente.efectoJugador(jugador);
	}
}