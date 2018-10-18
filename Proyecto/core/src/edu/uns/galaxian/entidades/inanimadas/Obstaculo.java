package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaNula;

public class Obstaculo extends EntidadViva implements Autonomo {
	
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./obstaculos/asteroideMarron.png"));
	private static final int VIDA_MAX = 300;
	
	private ColisionadorObstaculo colisionador;
	private Controlador controlador;
	private int fuerzaDeColision;
	private InteligenciaArtificial inteligencia;
	
	public Obstaculo(float xPos, float yPos, Controlador controlador) {
		super(new Vector2(xPos, yPos), 0, VIDA_MAX);
		this.controlador = controlador;
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 300;
		inteligencia = new InteligenciaNula();
	}
	
	public Obstaculo(float xPos, float yPos) {
		super(new Vector2(xPos, yPos), 0, VIDA_MAX);
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 100;
		inteligencia = new InteligenciaNula();
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

	public void dibujar(EntidadBatch batch) {
		batch.draw(TEXTURA, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float d) {
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			restarVida(getVida().getValor());
		}
		inteligencia.pensar(this);
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
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

	public void setControladorObstaculo(Controlador controlador) {
		this.controlador = controlador;
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial i) {
		inteligencia = i;
	}
	
}
