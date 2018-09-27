package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ArmaComun implements Arma {

	private static final long CADENCIA = 500;
	private static final int DAMAGE = 15;
	private static final int VELOCIDAD = 150;
	private static final int FACTOR_ESCALA = 1;
	private static Texture textura = new Texture(Gdx.files.internal("./disparos/laserGreen11.png"));
	private Disparo prototipo;
	private long ultimoDisparo;

	public ArmaComun(Disparo modelo) {
		prototipo = modelo;
		prototipo.setDamage(DAMAGE);
		prototipo.setVelocidad(VELOCIDAD);
		prototipo.setFactorEscala(FACTOR_ESCALA);
		prototipo.setTextura(textura);
		prototipo.setFactorEscala(FACTOR_ESCALA);
		ultimoDisparo = TimeUtils.millis() - CADENCIA;
	}

	public void setDisparoModelo(Disparo modelo){
		prototipo = modelo;
		prototipo.setDamage(DAMAGE);
		prototipo.setVelocidad(VELOCIDAD);
		prototipo.setFactorEscala(FACTOR_ESCALA);
		prototipo.setTextura(textura);
		prototipo.setFactorEscala(FACTOR_ESCALA);
	}

	public List<Disparo> disparar(int xPos, int yPos, Vector2 direccion) {
		Disparo nuevoDisparo = prototipo.clonar();
		nuevoDisparo.setPosicion(new Vector2(xPos, yPos));
		nuevoDisparo.setDireccion(direccion);
		List<Disparo> disparos = new LinkedList<>();
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			disparos.add(nuevoDisparo);
			ultimoDisparo = TimeUtils.millis();
		}
		return disparos;
	}

}
