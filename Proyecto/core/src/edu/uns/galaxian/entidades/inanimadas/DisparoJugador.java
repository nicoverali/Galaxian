package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;

public class DisparoJugador extends Disparo {
	
	private ColisionadorDisparoJugador colisionador;

	public DisparoJugador(int damage, int velocidad, float factor, Texture textura) {
		super(damage,velocidad,factor,textura);
		colisionador = new ColisionadorDisparoJugador(this);
	}
	
	public DisparoJugador() {
		super();
	}
	
	public DisparoJugador clonar() {
		DisparoJugador nuevo = new DisparoJugador(getDamage(),getVelocidad(),getFactor(),getTextura());
		return nuevo;
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
}
