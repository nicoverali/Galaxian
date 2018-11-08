package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoJugador;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class DisparoJugador extends Disparo {

	protected ColisionadorDisparoJugador colisionador = new ColisionadorDisparoJugador(this);
	protected Jugador jugador;

	public DisparoJugador(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo,
						  String texturaDir, Controlador controlador, Jugador jugador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador);
		this.jugador = jugador;
	}

	public void aceptarVisitor(Visitor col) {
		col.visitDisparoJugador(this);
	}
	
	public ColisionadorDisparoJugador getColisionador() {
		return colisionador;
	}
	
	public void sumarPuntajeJugador(int bonus) {
		jugador.sumarPuntaje(bonus);
	}
}
