package edu.uns.galaxian.entidades.inanimadas;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;
import edu.uns.galaxian.controladores.ControladorDisparo;

public class DisparoJugador extends Disparo {

	private ColisionadorDisparoJugador colisionador = new ColisionadorDisparoJugador(this);

	public DisparoJugador() {
	}

	public DisparoJugador(Vector2 posicion, Vector2 velocidad, int damage, Texture textura) {
		super(posicion, velocidad, damage, textura);
	}

	public DisparoJugador(Vector2 posicion, Vector2 velocidad, int damage, Texture textura, ControladorDisparo controlador) {
		super(posicion, velocidad, damage, textura, controlador);
	}

	public DisparoJugador clonar() {
		return new DisparoJugador(posicion, velocidad, fuerzaDeDisparo, textura);
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
}
