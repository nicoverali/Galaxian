package edu.uns.galaxian.nave.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.DisparoEnemigo;

public class NaveKamikaze implements  NaveEnemigo{
	
	private static final String DIR = "./enemigos/";
	private Texture textura = new Texture(Gdx.files.internal(DIR + "kamikaze/estandar.png"));
	
	private int vidaMax;
	private float velocidadMax;
	private int colision_damage;
	private Arma arma;
	private InteligenciaArtificial inteligencia;
	
	public NaveKamikaze(int vida, int colision_damage) {
		this.vidaMax = vida;
		this.colision_damage = colision_damage;
		arma = new ArmaComun(new DisparoEnemigo());
		velocidadMax = 300;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma nuevaArma) {
		arma = nuevaArma;
	}

	public Escudo getEscudo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEscudo(Escudo nuevoEscudo) {
		// TODO Auto-generated method stub
		
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public float getVelocidadMax() {
		return velocidadMax;
	}

	public float getRotacionInicial() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getAlto() {
		return textura.getHeight();
	}

	public float getAncho() {
		return textura.getWidth();
	}

	public void dibujar(SpriteBatch batch, Vector2 posicion) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public int getDamage() {
		return colision_damage;
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}
	
	
	
}
