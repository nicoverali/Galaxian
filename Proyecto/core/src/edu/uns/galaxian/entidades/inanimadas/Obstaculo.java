package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.controladores.ControladorObstaculo;
import edu.uns.galaxian.entidades.EntidadViva;

public class Obstaculo extends EntidadViva {
	
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./obstaculos/asteroideMarron.png"));
	private static final int VIDA_MAX = 550;
	
	private ColisionadorObstaculo colisionador;
	private ControladorObstaculo  controlador;
	private int fuerzaDeColision;
	
	public Obstaculo(int xPos, int yPos, ControladorObstaculo controlador) {
		super(new Vector2(xPos, yPos), 0, VIDA_MAX);
		this.controlador = controlador;
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 300;
	}
	
	public Obstaculo(int xPos, int yPos) {
		super(new Vector2(xPos, yPos), 0, VIDA_MAX);
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 100;
	}
	
	public int getFuerzaDeColision() {
		return fuerzaDeColision;
	}

	public float getAlto() {
		return TEXTURA.getHeight();
	}

	public float getAncho() {
		return TEXTURA.getWidth();
	}

	public void dibujar(SpriteBatch batch) {
		batch.draw(TEXTURA, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float d) {
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0)) {
			eliminar();
		}
	}

	public void eliminar() {
		controlador.deregistrar(this);
	}

	public void setVidaAlMaximo() {
		vida.setValor(VIDA_MAX);
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConObstaculo(this);
	}

	public Colisionador getColisionador() {
		return colisionador;
	}

	public void setControladorObstaculo(ControladorObstaculo controlador) {
		this.controlador = controlador;
	}
	
}
