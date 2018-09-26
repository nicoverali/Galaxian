package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;
import edu.uns.galaxian.controladores.ControladorDisparo;

public class DisparoJugador extends Disparo {
	
	private ColisionadorDisparoJugador colisionador = new ColisionadorDisparoJugador(this);

	public DisparoJugador(int damage, int velocidad, float factor, Vector2 direccion, Texture textura, ControladorDisparo controlador) {
		super(damage, velocidad, factor, direccion, textura, controlador);
	}

	public DisparoJugador(int damage, int velocidad, Vector2 direccion, Texture textura){
		super(damage, velocidad, direccion, textura);
	}
	
	public DisparoJugador() {
		super();
	}
	
	public DisparoJugador clonar() {
		DisparoJugador nuevoDisparo = new DisparoJugador(this.damage, this.velocidad, this.direccion, this.textura);
		return nuevoDisparo;
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
}
