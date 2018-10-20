package edu.uns.galaxian.entidades.inanimadas.powerups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorPowerUp;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class PowerUp extends Entidad {

	private Controlador controlador;
	private ColisionadorPowerUp colisionador;
	protected Texture textura;
	
	public PowerUp(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador){
		super(posicion, velocidad,  rotacion);
		this.controlador=controlador;
		colisionador= new ColisionadorPowerUp(this);
	}
	
	public abstract void efectoJugador(Jugador jugador);
	
	@Override
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConPowerUp(this);
	}

	@Override
	public Colisionador getColisionador() {
		return colisionador;
	}

	@Override
	public float getAlto() {
		return textura.getHeight();
	}

	@Override
	public float getAncho() {
		return textura.getWidth(); 
	}

	@Override
	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	@Override
	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			eliminar();
		}
	}

	@Override
	public void eliminar() {
		controlador.eliminarEntidad(this);
	}
	
}
