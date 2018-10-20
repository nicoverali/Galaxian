package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.EntidadBatch;

public abstract class Disparo extends Entidad {

	protected int fuerzaDeDisparo;
	protected Texture textura;
	protected Controlador controlador;
	protected HBRectangulo box;

	public Disparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, Texture textura, Controlador controlador) {
		super(posicion, velocidad, rotacion);
		this.fuerzaDeDisparo = fuerzaDeDisparo;
		this.textura = textura;
		this.controlador = controlador;
		box = new HBRectangulo(this,textura.getHeight(),textura.getWidth());
	}

	/**
	 * Retorna un nuevo disparo con los mismos atributos
	 * @return Clon de este disparo
	 */
	public abstract Disparo clonar();

	public float getAlto() {
		return textura.getHeight();
	}

	public float getAncho() {
		return textura.getWidth();
	}

	public int getFuerzaDeDisparo() {
		return fuerzaDeDisparo;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y < 0)) {
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
