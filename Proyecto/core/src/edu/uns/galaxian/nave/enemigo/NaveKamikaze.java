package edu.uns.galaxian.nave.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;

public class NaveKamikaze extends NaveEnemigo{
	
	private static final String TEXTURA_DIR = "./enemigos/kamikaze/estandar.png";

	private int vidaMax;
	private float velocidadMax;
	private int colisionDamage;
	// TODO Crear inteligencia del kamikaze y asignarsela a esta nave de manera fija
	private InteligenciaArtificial inteligenciaDeAtaque;
	
	public NaveKamikaze(int vida, float velocidadMax, int colisionDamage) {
		this.vidaMax = vida;
		this.colisionDamage = colisionDamage;
		this.velocidadMax = velocidadMax;
		textura = new Texture(Gdx.files.internal(TEXTURA_DIR));
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public float getVelocidadMax() {
		return velocidadMax;
	}

	public float getRotacionInicial() {
		return 180;
	}

	public int getDamage() {
		return colisionDamage;
	}

	public InteligenciaArtificial getInteligenciaDeAtaque() {
		return inteligenciaDeAtaque;
	}
}
