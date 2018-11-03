package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import edu.uns.galaxian.controlador.Controlador;

public class Asteroide extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro1";
	
	public Asteroide(float posX, float posY, Controlador controlador) {
		super(posX,posY,TEXTURA_DIR, controlador);
	}

}
