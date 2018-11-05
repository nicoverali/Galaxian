package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.ColisionadorAsteroide;
import edu.uns.galaxian.controlador.Controlador;

public class Asteroide extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro1";
	
	public Asteroide(float posX, float posY, Controlador controlador) {
		super(posX,posY,TEXTURA_DIR, controlador);
		colisionador = new ColisionadorAsteroide(this);
	}
	
	public void fragmentar() {
		int cantFragmentos = 2;
		double angulo;
		for(int i=0; i<cantFragmentos; i++) {
			angulo = elegirDireccion();
			Vector2 direccion = new Vector2((float)Math.cos(angulo), (float)Math.sin(angulo));
			Fragmento fragmento  = new Fragmento(getPosicion(), direccion, controlador);
			controlador.agregarEntidad(fragmento);
		}
	}
	
	private double elegirDireccion() {
		Random rand = new Random();
		int numerador = rand.nextInt();
		int denominador = rand.nextInt();
		while(denominador==0) {
			denominador = rand.nextInt();
		}
		double angulo = ((numerador*Math.PI)/denominador);
		return angulo;
	}

}
