package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoJugador implements Colisionador<Disparo> {

	private Disparo objetoFuente;

	public void colisionarConEnemigo(Enemigo enemigo) {
		enemigo.restarVida(objetoFuente.getDamage());
		enemigo.eliminar();
		objetoFuente.eliminar();
	}

	public void colisionarConDisparo(Disparo disparo) {
		// Un disparo no afecta a otro disparo
	}

	public void colisionarConJugador(Jugador jugador) {
		// Un disparo producido por el Jugador no afecta a este
	}

	public void setObjetoFuente(Disparo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

}
