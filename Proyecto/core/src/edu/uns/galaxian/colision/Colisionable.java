package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;

public interface Colisionable {
	
	public int getAlto();
	public int getAncho();
	public Vector2 getVector();
	public Colisionador getColisionador();
}
