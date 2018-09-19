package edu.uns.galaxian.entidades.equipamiento;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.Colisionador;
import edu.uns.galaxian.colision.ColisionadorDisparo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaDisparoDoble implements Arma {

	private static final int DAMAGE=15;
	private static final int VELOCIDAD=100;
	
	@Override
	public List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion, Colisionador colisionador) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Disparo> disparar(Vector2 posicion, Vector2 direccion, Colisionador colisionador) {
		// TODO Auto-generated method stub
		return null;
	}
}
