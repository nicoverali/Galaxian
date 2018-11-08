package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEspecial;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.BlackHole;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class DisparoEspecial extends DisparoJugador {

	public DisparoEspecial(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, 
						   String texturaDir, Controlador controlador, Jugador jugador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador,jugador);
		colisionador = new ColisionadorDisparoEspecial(this);
	}

	public void aceptarVisitor(Visitor col) {
		col.visitDisparoJugador(this);
	}
	
	public void efecto() {
		BlackHole blackHole = new BlackHole(posicion.x,posicion.y,controlador);
		controlador.agregarEntidad(blackHole);
	}
	
}
