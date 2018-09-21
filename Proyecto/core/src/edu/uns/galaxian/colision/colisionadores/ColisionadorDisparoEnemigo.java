package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo implements Colisionador<DisparoEnemigo> {

	private DisparoEnemigo objetoFuente;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getDamage());
		objetoFuente.eliminar();
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// Un disparo enemigo no afecta a un enemigo.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// TODO Decidir si un disparo Jugador puede afectar a un enemigo.
	}
	
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// Un disparo enemigo no afecta a otro disparo enemigo.
	}

}
