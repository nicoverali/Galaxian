package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorDisparoEnemigo extends ColisionadorNulo<DisparoEnemigo> {

	private DisparoEnemigo objetoFuente;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo objetoFuente) {
		this.objetoFuente = objetoFuente;
	}

	public void colisionarConJugador(Jugador jugador) {
		objetoFuente.eliminar();
	}
  
	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.eliminar();
	}

	public void colisionarConEscudo(Escudo escudo) {
		objetoFuente.eliminar();
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		objetoFuente.eliminar();
	}
	
}
