package edu.uns.galaxian.colision;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo implements Colisionador {

	/**
	 * Se resta al jugador un porcentaje de su vida, que depende de la fuerza de disparo del enemigo.
	 */
	public void colisionarConJugador(Jugador jugador) {
		//  TODO falta determinar como obtener el daño del disparo
	}
	
	public void colisionarConDisparoJugador(Disparo disparo) {}

	/**
	 * Cuando un disparo enemigo colisiona con un enemigo no hay ningun efecto
	 */
	public void colisionarConEnemigo(Enemigo enemigo) {}

	/**
	 * Si un disparo enemigo colisiona con un disparo enemigo, ambos siguen su trayectoria sin destruirse
	 */
	public void colisionarConDisparoEnemigo(Disparo disparo) {}

}
