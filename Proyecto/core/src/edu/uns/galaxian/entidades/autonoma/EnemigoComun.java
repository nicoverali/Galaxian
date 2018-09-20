package edu.uns.galaxian.entidades.autonoma;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.ColisionadorDisparoEnemigo;
import edu.uns.galaxian.colision.ColisionadorEnemigo;
import edu.uns.galaxian.entidades.EntidadColisionable;

public class EnemigoComun extends Enemigo {
	
	private static final int ALTO = 37;
	private static final int ANCHO = 37;
	private ColisionadorEnemigo colisionadorEnemigo;

	public EnemigoComun(int xPos, int yPos, int vidaMaxima) {
		super(xPos, yPos, vidaMaxima);
		colisionadorDisparoEnemigo = new ColisionadorDisparoEnemigo();
		colisionadorEnemigo = new ColisionadorEnemigo();
	}

	@Override
	public int getAlto() {
		return ALTO;
	}

	@Override
	public int getAncho() {
		return ANCHO;
	}

	@Override
	public void aceptarColision(EntidadColisionable entidad) {
		entidad.getColisionador().colisionarConEnemigo(this);
	}

}
