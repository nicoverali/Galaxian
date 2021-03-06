package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEspecial;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class ColisionadorDisparoEspecial extends ColisionadorDisparoJugador {

	private DisparoEspecial objeto;
	
	public ColisionadorDisparoEspecial(DisparoEspecial objetoFuente) {
		super(objetoFuente);
		objeto = objetoFuente;
	}
	
	public void visitEnemigo(Enemigo disparo) {
		objeto.efecto();
		objeto.eliminar();
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		objeto.efecto();
		objeto.eliminar();
	}

	public void visitBarricada(Barricada barricada) {
		objeto.efecto();
		objeto.eliminar();
	}
	
}