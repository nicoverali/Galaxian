package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEnemigo;

public class DisparoEnemigo extends Disparo {
	
	private ColisionadorDisparoEnemigo colisionador;

	public DisparoEnemigo(int damage, int velocidad, float factor, Texture textura) {
		super(damage,velocidad,factor,textura);
		colisionador = new ColisionadorDisparoEnemigo(this);
	}
	
	public DisparoEnemigo clonar() {
		DisparoEnemigo nuevo = new DisparoEnemigo(getDamage(),getVelocidad(),getFactor(),getTextura());
		return nuevo;
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoEnemigo(this);
	}
	
	public ColisionadorDisparoEnemigo getColisionador() {
		return colisionador;
	}
	
}