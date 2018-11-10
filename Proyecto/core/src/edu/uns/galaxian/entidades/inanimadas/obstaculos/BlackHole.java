package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import edu.uns.galaxian.colision.colisionadores.ColisionadorBlackHole;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.controlador.Controlador;

public class BlackHole extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/blackhole";

	public BlackHole(float xPos, float yPos, Controlador controlador) {
		super(xPos, yPos, TEXTURA_DIR, controlador);
		fuerzaDeColision = 10;
		vida.setValor(900);
		colisionador = new ColisionadorBlackHole(this);
		box = new HBRectangulo(this,textura.getRegionHeight()+40,textura.getRegionWidth()+40);
	}
}