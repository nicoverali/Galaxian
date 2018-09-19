package edu.uns.galaxian.entidades.equipamiento;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.Colisionador;
import edu.uns.galaxian.colision.ColisionadorDisparo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun implements Arma {

	private static final int DAMAGE=15;
	private static final int VELOCIDAD=100;
	private static final int FACTOR_ESCALA=1;
	private static final Disparo prototipo = new Disparo(DAMAGE,VELOCIDAD,FACTOR_ESCALA);

	@Override
	public List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion, Colisionador colisionador) {
		Disparo nuevoDisparo = prototipo.clonar();
		nuevoDisparo.setFactorEscala(1);
		nuevoDisparo.setDireccion(direccion);
		nuevoDisparo.setColisionador(colisionador);
		List<Disparo> disparos = new LinkedList<Disparo>();
		disparos.add(nuevoDisparo);
		return disparos;
	}
	@Override
	public List<Disparo> disparar(Vector2 posicion, Vector2 direccion, Colisionador colisionador) {
		// TODO Auto-generated method stub
		return null;
	}
}
