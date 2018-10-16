package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEnemigo;
import edu.uns.galaxian.controladores.ControladorDisparo;

public class DisparoEnemigo extends Disparo {
	
	private ColisionadorDisparoEnemigo colisionador = new ColisionadorDisparoEnemigo(this);

	public DisparoEnemigo() {
	}

	public DisparoEnemigo(Vector2 posicion, Vector2 velocidad, int damage, Texture textura) {
		super(posicion, velocidad, damage, textura);
	}

	public DisparoEnemigo(Vector2 posicion, Vector2 velocidad, int damage, Texture textura, ControladorDisparo controlador) {
		super(posicion, velocidad, damage, textura, controlador);
	}

	public DisparoEnemigo clonar() {
		return new DisparoEnemigo(posicion, velocidad, fuerzaDeDisparo, textura);
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoEnemigo(this);
	}
	
	public ColisionadorDisparoEnemigo getColisionador() {
		return colisionador;
	}
	
}