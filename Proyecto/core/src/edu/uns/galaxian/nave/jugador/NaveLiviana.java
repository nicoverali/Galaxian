package edu.uns.galaxian.nave.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;

public class NaveLiviana implements NaveJugador {

	private Arma arma;
	private Escudo escudo;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static final int VIDA_MAXIMA = 150;
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./jugador/naveLiviana.png"));
	
	public NaveLiviana() {
		
	}
	
	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma nuevaArma) {
		arma = nuevaArma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo nuevoEscudo) {
		escudo = nuevoEscudo;
	}

	public int getVidaMax() {
		return VIDA_MAXIMA;
	}

	public float getVelocidadMax() {
		return VELOCIDAD_MAXIMA;
	}

	public float getRotacionInicial() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getAlto() {
		return TEXTURA.getHeight();
	}

	public float getAncho() {
		return TEXTURA.getWidth();
	}

	public void dibujar(SpriteBatch batch, Vector2 posicion) {
		batch.draw(TEXTURA, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
		
	}

}
