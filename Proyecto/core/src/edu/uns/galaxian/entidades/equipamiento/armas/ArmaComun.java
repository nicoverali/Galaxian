package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun implements Arma {

	private static final int DAMAGE=15;
	private static final int VELOCIDAD=150;
	private static final int FACTOR_ESCALA=1;
	private static Disparo prototipo;
	private static Texture textura = new Texture(Gdx.files.internal("./Disparo/laserGreen11.png"));
	
	public ArmaComun(Disparo modelo) {
		prototipo = modelo;
		prototipo.setDamage(DAMAGE);
		prototipo.setVelocidad(VELOCIDAD);
		prototipo.setFactorEscala(FACTOR_ESCALA);
		prototipo.setTextura(textura);
		prototipo.setFactorEscala(FACTOR_ESCALA);
	}

	public void setDisparoModelo(Disparo modelo){
		prototipo = modelo;
	}

	public List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion) {
		Disparo nuevoDisparo = prototipo.clonar();
		nuevoDisparo.setPosicion(new Vector2(xPos,yxPos));
		nuevoDisparo.setDireccion(direccion);
		List<Disparo> disparos = new LinkedList<>();
		disparos.add(nuevoDisparo);
		return disparos;
	}

}
