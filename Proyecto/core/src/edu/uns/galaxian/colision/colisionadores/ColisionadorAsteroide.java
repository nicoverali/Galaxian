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
	
	public void colisionarConObstaculo(Obstaculo obstaculo) {
		asteroide.restarVida(asteroide.getVida().getValor());
		asteroide.fragmentar();
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		asteroide.restarVida(asteroide.getVida().getValor());		
		asteroide.fragmentar();
	}

}
