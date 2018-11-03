package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorBarricada;
import edu.uns.galaxian.controlador.Controlador;

public class Barricada extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro4";
	
	public Barricada(float xPos, float yPos, Controlador controlador) {
		super(xPos, yPos, TEXTURA_DIR, controlador);
		colisionador = new ColisionadorBarricada(this);
	}
	
	public void eliminar() {
		Vector2 direccion  = new Vector2(1,-1);
		Vector2 direccion2 = new Vector2(-1,-1);
		Fragmento fragmento  = new Fragmento(getPosicion(), direccion, controlador);
		Fragmento fragmento2 = new Fragmento(getPosicion(), direccion2, controlador);
		controlador.agregarEntidad(fragmento);
		controlador.agregarEntidad(fragmento2);
		controlador.eliminarEntidad(this);
	}
	
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConBarricada(this);
	}

}