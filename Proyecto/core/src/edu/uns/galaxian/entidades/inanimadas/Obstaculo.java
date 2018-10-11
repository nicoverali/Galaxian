package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.controladores.ControladorObstaculo;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.status.StatusMutableVida;
import edu.uns.galaxian.entidades.status.StatusVida;

public class Obstaculo implements EntidadViva {
	
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./jugador/VERDE/navePesada.png"));
	private static final int VIDA_MAX = 300;
	
	private ColisionadorObstaculo colisionador;
	private ControladorObstaculo  controlador;
	private StatusMutableVida status;
	private int damage;
	
	public Obstaculo(int xPos, int yPos, ControladorObstaculo controlador) {
		status = new StatusMutableVida(new Vector2(xPos,yPos), 45 , VIDA_MAX);
		this.controlador = controlador;
		colisionador = new ColisionadorObstaculo(this);
		damage = 300;
	}
	
	public Obstaculo(int xPos, int yPos) {
		status = new StatusMutableVida(new Vector2(xPos,yPos), 45 , VIDA_MAX);
		colisionador = new ColisionadorObstaculo(this);
		damage = 100;
	}
	
	public int getColisionDamage() {
		return damage;
	}

	public float getAlto() {
		return TEXTURA.getHeight();
	}

	public float getAncho() {
		return TEXTURA.getWidth();
	}

	public void dibujar(SpriteBatch batch) {
		Vector2 posicion = status.getPosicion();
		batch.draw(TEXTURA, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float d) {
		if((status.getPosicion().y > Gdx.graphics.getHeight()) || (status.getPosicion().y<0)) {
			eliminar();
		}
	}

	public void eliminar() {
		controlador.deregistrar(this);
	}

	public void setVidaAlMaximo() {
		status.setVida(VIDA_MAX);
	}

	public void restarVida(int vidaARestar) throws IllegalArgumentException {
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = status.getVida() - vidaARestar;
		if(nuevaVida<=0) {
			eliminar();
		}
		else { status.setVida(Math.max(0, nuevaVida)); }
	}

	public StatusVida getStatus() {
		return status;
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
