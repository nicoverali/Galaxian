package edu.uns.galaxian.entidades.inanimadas.disparos;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;
import edu.uns.galaxian.controladores.Controlador;

public class DisparoJugador extends Disparo {

	private ColisionadorDisparoJugador colisionador = new ColisionadorDisparoJugador(this);

	public DisparoJugador(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, Texture textura, Controlador controlador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, textura, controlador);
	}

	public DisparoJugador clonar() {
		return new DisparoJugador(posicion.cpy(), velocidad.cpy(), rotacion, fuerzaDeDisparo, textura, controlador);
	}
	
	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
}
