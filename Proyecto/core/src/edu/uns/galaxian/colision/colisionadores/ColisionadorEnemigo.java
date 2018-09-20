package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEnemigo implements Colisionador<Enemigo> {

	private Enemigo objetoFuente;

	public ColisionadorEnemigo(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	@Override
	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getColisionDamage());
	}

	@Override
	public void colisionarConEnemigo(Enemigo enemigo) {
		// La colision entre enemigos no produce ningun efecto
	}

	@Override
	public void colisionarConDisparo(Disparo disparo) {
		// TODO La colision con un disparo no produce ningun efecto por el momento
	}

	public void setObjetoFuente(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

}
