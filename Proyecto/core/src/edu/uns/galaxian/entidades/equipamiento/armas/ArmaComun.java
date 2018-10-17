package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun<T extends Disparo> implements Arma<T> {

	private static final long CADENCIA = 500;
	private static final int DAMAGE = 35;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./disparos/laserGreen11.png"));
	private T prototipo;
	private long ultimoDisparo;

	public ArmaComun(T modelo) {
		prototipo = modelo;
		prototipo.setFuerzaDeDisparo(DAMAGE);
		prototipo.setTextura(TEXTURA);
		ultimoDisparo = TimeUtils.millis() - CADENCIA;
	}

	public Collection<T> disparar(Vector2 posicion, float anguloDeDisparo) {
		Collection<T> disparos = new ArrayList<T>(1);
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			T nuevoDisparo = (T) prototipo.clonar();
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			nuevoDisparo.setPosicion(posicion);
			nuevoDisparo.setRotacion(anguloDeDisparo);
			nuevoDisparo.setVelocidad(velocidad);
			disparos.add(nuevoDisparo);
			ultimoDisparo = TimeUtils.millis();
		}
		return disparos;
	}
}
