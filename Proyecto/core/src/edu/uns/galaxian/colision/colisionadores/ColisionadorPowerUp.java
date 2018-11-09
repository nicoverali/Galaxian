package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
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

	public void visitDisparoJugador(DisparoJugador disparo) {
		// TODO Decidir si un disparo jugador va a afectar al powerUp.
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		// TODO Decidir si un disparo enemigo va a afectar al powerUp.
	}

}