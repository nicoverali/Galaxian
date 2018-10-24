package edu.uns.galaxian.entidades.inanimadas.powerups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorPowerUp;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class PowerUp extends Entidad {

	protected Controlador controlador;
	protected ColisionadorPowerUp colisionador;
	protected TextureRegion textura;
	protected HBCirculo box;
	
	public PowerUp(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador){
		super(posicion, velocidad,  rotacion);
		this.controlador=controlador;
		colisionador= new ColisionadorPowerUp(this);
	}
	
	public abstract void efectoJugador(Jugador jugador);
	
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConPowerUp(this);
	}

	public Colisionador getColisionador() {
		return colisionador;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion, rotacion);
	}

	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			eliminar();
		}
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}
	
	public HitBox getHitBox() {
		return box;
	}
}
