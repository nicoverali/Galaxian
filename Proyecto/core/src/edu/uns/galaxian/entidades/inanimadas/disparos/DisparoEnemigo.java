package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEnemigo;
import edu.uns.galaxian.controlador.Controlador;

public class DisparoEnemigo extends Disparo {
	
	private ColisionadorDisparoEnemigo colisionador = new ColisionadorDisparoEnemigo(this);

	public DisparoEnemigo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador) {
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador);
	}

	public void aceptarVisitor(Visitor col) {
		col.visitDisparoEnemigo(this);
	}
	
	public ColisionadorDisparoEnemigo getColisionador() {
		return colisionador;
	}
	
}