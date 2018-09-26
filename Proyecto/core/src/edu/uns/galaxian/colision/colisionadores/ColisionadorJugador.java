package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorJugador implements Colisionador<Jugador> {
	
	private Jugador objetoFuente;

	public ColisionadorJugador(Jugador objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getVida());
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getDamage());
	}

}
