package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.util.EntidadBatch;

public class BlackHole extends Obstaculo {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro3";
	private Texture textura;

	public BlackHole(float xPos, float yPos, Controlador controlador) {
		super(xPos, yPos, TEXTURA_DIR, controlador);
		textura = new Texture(Gdx.files.internal("obstaculos/supernova2.png"));
		fuerzaDeColision = 0;
	}
	
	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion.x, posicion.y, 40, 40);
	}

}
