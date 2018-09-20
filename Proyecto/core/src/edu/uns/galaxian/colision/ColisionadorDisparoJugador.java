package edu.uns.galaxian.colision;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoJugador implements Colisionador {
	
	private Disparo disparoJugador;

	/**
	 * El disparo del jugador le reduce la vida al enemigo
	 */
	public void colisionarConEnemigo(Enemigo enemigo) {
		// TODO determinar como obtener el daño del disparo
		enemigo.eliminar();
	}
	
	@Override
	public void colisionarConDisparoEnemigo(Disparo disparo) {}
	
	public void colisionarConDisparoJugador(Disparo disparo) {}
	
	public void colisionarConJugador(Jugador jugador) {}

}
