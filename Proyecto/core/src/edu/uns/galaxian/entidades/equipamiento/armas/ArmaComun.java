package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun implements Arma {

	private static final long CADENCIA = 500;
	private static final int DAMAGE = 35;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./disparos/laserGreen11.png"));
	private Disparo prototipo;
	private long ultimoDisparo;

	public ArmaComun(Disparo modelo) {
		prototipo = modelo;
		prototipo.setFuerzaDeDisparo(DAMAGE);
		prototipo.setTextura(TEXTURA);
		ultimoDisparo = TimeUtils.millis() - CADENCIA;
	}

	public void setDisparoModelo(Disparo modelo){
		prototipo = modelo;
		prototipo.setFuerzaDeDisparo(DAMAGE);
		prototipo.setTextura(TEXTURA);
	}

	public Collection<Disparo> disparar(Vector2 posicion, float anguloDeDisparo) {
		Collection<Disparo> disparos = new ArrayList<>(1);
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			Disparo nuevoDisparo = prototipo.clonar();
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
