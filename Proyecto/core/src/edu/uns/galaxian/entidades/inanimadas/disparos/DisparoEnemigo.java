package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEnemigo;
import edu.uns.galaxian.controladores.Controlador;

public class DisparoEnemigo extends Disparo {
	
	private ColisionadorDisparoEnemigo colisionador = new ColisionadorDisparoEnemigo(this);

	public DisparoEnemigo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, Texture textura, Controlador controlador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, textura, controlador);
	}

	public DisparoEnemigo clonar() {
		return new DisparoEnemigo(posicion.cpy(), velocidad.cpy(), rotacion, fuerzaDeDisparo, textura, controlador);
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoEnemigo(this);
	}
	
	public ColisionadorDisparoEnemigo getColisionador() {
		return colisionador;
	}
	
}