package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaDisparoDoble implements Arma {

	private static final long CADENCIA = 1000;
	private static final int DAMAGE = 35;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./disparos/laserGreen11.png"));
	private Disparo prototipo;
	private long ultimoDisparo;

	public ArmaDisparoDoble(Disparo modelo) {
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
		Collection<Disparo> disparos = new ArrayList<>(2);
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			Disparo nuevoDisparo_1 = prototipo.clonar();
			Disparo nuevoDisparo_2 = prototipo.clonar();
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			nuevoDisparo_1.setPosicion(posicion.cpy().add(10,0));
			nuevoDisparo_1.setRotacion(anguloDeDisparo);
			nuevoDisparo_1.setVelocidad(velocidad);
			nuevoDisparo_2.setPosicion(posicion.cpy().add(-10,0));
			nuevoDisparo_2.setRotacion(anguloDeDisparo);
			nuevoDisparo_2.setVelocidad(velocidad);
			disparos.add(nuevoDisparo_1);
			disparos.add(nuevoDisparo_2);
			ultimoDisparo = TimeUtils.millis();
		}
		return disparos;
	}

}
