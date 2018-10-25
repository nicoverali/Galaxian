package edu.uns.galaxian.entidades.inanimadas.disparos;


import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;
import edu.uns.galaxian.controlador.Controlador;

public class DisparoJugador extends Disparo {

	private ColisionadorDisparoJugador colisionador = new ColisionadorDisparoJugador(this);

	public DisparoJugador(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador);
	}

	public void aceptarColision(Colisionador col) {
		col.colisionarConDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
}
