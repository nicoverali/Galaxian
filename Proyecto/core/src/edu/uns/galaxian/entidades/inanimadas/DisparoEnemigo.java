package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEnemigo;
import edu.uns.galaxian.controladores.ControladorDisparo;

public class DisparoEnemigo extends Disparo {
	
	private ColisionadorDisparoEnemigo colisionador = new ColisionadorDisparoEnemigo(this);

	public DisparoEnemigo(int damage, int velocidad, float factor, Vector2 direccion, Texture textura, ControladorDisparo controlador) {
		super(damage, velocidad, factor, direccion, textura, controlador);
	}

	public DisparoEnemigo(int damage, int velocidad, Vector2 direccion, Texture textura){
		super(damage, velocidad, direccion, textura);
	}
	
	public DisparoEnemigo() {
		super();
	}
	
	public DisparoEnemigo clonar() {
		DisparoEnemigo nuevoDisparo = new DisparoEnemigo(this.damage, this.velocidad, this.direccion, this.textura);
		return nuevoDisparo;
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoEnemigo(this);
	}
	
	public ColisionadorDisparoEnemigo getColisionador() {
		return colisionador;
	}
	
}