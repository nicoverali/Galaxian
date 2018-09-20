package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo implements Colisionador<Disparo> {

	private Disparo objetoFuente;

	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getDamage());
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// Un disparo enemigo no afecta a un enemigo
	}

	public void colisionarConDisparo(Disparo disparo) {
		// Un disparo no afecta a otro disparo
	}

	public void setObjetoFuente(Disparo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

}
