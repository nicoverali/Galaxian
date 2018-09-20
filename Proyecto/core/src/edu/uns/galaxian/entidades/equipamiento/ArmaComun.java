package edu.uns.galaxian.entidades.equipamiento;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun implements Arma {

	private static final int DAMAGE=15;
	private static final int VELOCIDAD=150;
	private static final int FACTOR_ESCALA=1;
	private Texture textura = new Texture(Gdx.files.internal(String.format("./Disparo/laserGreen11.png")));
	private final Disparo prototipo = new Disparo(DAMAGE,VELOCIDAD,FACTOR_ESCALA,textura);

	public List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion, Colisionador colisionador) {
		Disparo nuevoDisparo = prototipo.clonar();
		nuevoDisparo.setPosicion(new Vector2(xPos,yxPos));
		nuevoDisparo.setDireccion(direccion);
		nuevoDisparo.setColisionador(colisionador);
		List<Disparo> disparos = new LinkedList<Disparo>();
		disparos.add(nuevoDisparo);
		return disparos;
	}

	public List<Disparo> disparar(Vector2 posicion, Vector2 direccion, Colisionador colisionador) {
		Disparo nuevoDisparo = prototipo.clonar();
		nuevoDisparo.setPosicion(posicion);
		nuevoDisparo.setDireccion(direccion);
		nuevoDisparo.setColisionador(colisionador);
		List<Disparo> disparos = new LinkedList<Disparo>();
		disparos.add(nuevoDisparo);
		return disparos;
	}
}
