package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;

public class ColisionadorDisparoJugador extends VisitorAdapter<DisparoJugador> {

	private DisparoJugador objetoFuente;
	
	public ColisionadorDisparoJugador(DisparoJugador objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void visitEnemigo(Enemigo enemigo) {
		objetoFuente.eliminar();
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.eliminar();
	}

	public void visitBarricada(Barricada obstaculoEnemigo) {
		objetoFuente.eliminar();
	}
}
