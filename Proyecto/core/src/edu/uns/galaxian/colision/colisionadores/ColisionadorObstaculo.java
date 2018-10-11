package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorObstaculo implements Colisionador<Obstaculo> {
	
	private Obstaculo objetoFuente;
	
	public ColisionadorObstaculo(Obstaculo obstaculo) {
		objetoFuente = obstaculo;
	}

	public void colisionarConJugador(Jugador jugador) {
		jugador.restarVida(objetoFuente.getColisionDamage());
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		enemigo.restarVida(objetoFuente.getColisionDamage());
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getDamage());
		disparo.eliminar();
		System.out.println("holaaaaaaaaaaaa");
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getDamage());
		disparo.eliminar();
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		obstaculo.eliminar();
		objetoFuente.eliminar();
	}

}
