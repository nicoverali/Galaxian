package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import edu.uns.galaxian.controlador.Controlador;

public class BlackHole extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/blackhole";

	public BlackHole(float xPos, float yPos, Controlador controlador) {
		super(xPos, yPos, TEXTURA_DIR, controlador);
		fuerzaDeColision = 0;
		vida.setValor(700);
	}
}
