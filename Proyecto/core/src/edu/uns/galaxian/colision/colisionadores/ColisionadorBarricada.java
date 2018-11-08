package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class ColisionadorBarricada extends ColisionadorObstaculo {
	
	public ColisionadorBarricada(Barricada obstaculoEnemigo) {
		super(obstaculoEnemigo);
		objetoFuente = obstaculoEnemigo;
	}
	
	public void visitObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(objetoFuente.getVida().getValor());
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		// El obstaculo si afecta a una barricada, sin embargo las barricadas no se afectan entre si.
	}
	
}
