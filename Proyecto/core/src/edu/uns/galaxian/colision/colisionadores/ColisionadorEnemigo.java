package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEnemigo implements Colisionador<Enemigo> {

	private Enemigo objetoFuente;

	public ColisionadorEnemigo(Enemigo objetoFuente){
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getColisionDamage());
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// La colision entre enemigos no produce ningun efecto.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getDamage());
		if(objetoFuente.getVida() == 0){
			objetoFuente.eliminar();
		}
	}
	
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// Un disparo enemigo no afecta al enemigo.
	}

}
