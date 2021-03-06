package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.inanimadas.obstaculos.Asteroide;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class ColisionadorAsteroide extends ColisionadorObstaculo {
	
	protected Asteroide asteroide;
	
	public ColisionadorAsteroide(Asteroide asteroide) {
		super(asteroide);
		this.asteroide = asteroide;
	}
	
	public void visitObstaculo(Obstaculo obstaculo) {
		asteroide.restarVida(asteroide.getVida().getValor());
		asteroide.fragmentar();
	}

	public void visitBarricada(Barricada barricada) {
		asteroide.restarVida(asteroide.getVida().getValor());		
		asteroide.fragmentar();
	}

}