package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo implements Colisionador<DisparoEnemigo> {

	private DisparoEnemigo objetoFuente;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
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

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		obstaculo.restarVida(objetoFuente.getDamage());
		objetoFuente.eliminar();
	}

}
