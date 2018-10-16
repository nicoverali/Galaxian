package edu.uns.galaxian.nave.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaAleatoria;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;
import edu.uns.galaxian.entidades.status.GameObject;

public class NaveKamikaze extends NaveEnemigo{
	
	private static final String TEXTURA_DIR = "./enemigos/kamikaze/estandar.png";

	private int vidaMax;
	private float velocidadMax;
	private int colisionDamage;
	// TODO Crear inteligencia del kamikaze y asignarsela a esta nave de manera fija
	private InteligenciaArtificial inteligenciaDeAtaque;

	// REVIEW El estado que se recibe es para despues poder darselo a la inteligencia
	public NaveKamikaze(int vida, float velocidadMax, int colisionDamage, GameObject estadoJugador) {
		this.vidaMax = vida;
		this.colisionDamage = colisionDamage;
		this.velocidadMax = velocidadMax;
		textura = new Texture(Gdx.files.internal(TEXTURA_DIR));
		inteligenciaDeAtaque = new InteligenciaAleatoria();
		
		setArma(new ArmaComun(new DisparoEnemigo()));
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public float getVelocidadMax() {
		return velocidadMax;
	}

	public float getRotacionInicial() {
		return 270;
	}

	public int getDamage() {
		return colisionDamage;
	}

	public InteligenciaArtificial getInteligenciaDeAtaque() {
		return inteligenciaDeAtaque;
	}
}
