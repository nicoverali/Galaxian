package edu.uns.galaxian.colision;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public interface Colisionador {

	public void colisionarConJugador(Jugador jugador);
	public void colisionarConEnemigo(Enemigo enemigo);
	public void colisionadrConDisparoJugador(DisparoJugador disparo);
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo);
}
