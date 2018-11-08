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
	
	/**
	 * Generacion de 2 fragmentos, cuyas direcciones son pasadas como parametro.
	 * @param direccion1 Direccion del primer fragmento.
	 * @param direccion2 Direccion del segundo fragmento.
	 */
	public void fragmentar(Vector2 direccion1, Vector2 direccion2) {
		Fragmento fragmento1  = new Fragmento(getPosicion(), direccion1, controlador);
		Fragmento fragmento2 = new Fragmento(getPosicion(), direccion2, controlador);
		controlador.agregarEntidad(fragmento1);
		controlador.agregarEntidad(fragmento2);
	}
	
	/**
	 * Esta implementacion genera fragmentos en direcciones al azar (utilizando propiedades matematicas).
	 */
	public void fragmentar() {
		int cantFragmentos = 2;
		double angulo;
		for(int i=0; i<cantFragmentos; i++) {
			angulo = calcularAngulo();
			Vector2 direccion = new Vector2((float)Math.cos(angulo), (float)Math.sin(angulo));
			Fragmento fragmento  = new Fragmento(getPosicion(), direccion, controlador);
			controlador.agregarEntidad(fragmento);
		}
	}
	
	/**
	 * Se calcula un angulo al azar.
	 * @return Valor del angulo calculado.
	 */
	private double calcularAngulo() {
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
