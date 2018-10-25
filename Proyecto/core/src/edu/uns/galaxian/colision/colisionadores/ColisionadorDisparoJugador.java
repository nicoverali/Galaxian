package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.ObstaculoEnemigo;

public class ColisionadorDisparoJugador extends ColisionadorNulo<DisparoJugador> {

	private DisparoJugador objetoFuente;
	
	public ColisionadorDisparoJugador(DisparoJugador objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.eliminar();
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.eliminar();
	}

	public void colisionarConBarricada(ObstaculoEnemigo obstaculoEnemigo) {
		objetoFuente.eliminar();
	}
}
