package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.EntidadBatch;

public abstract class Disparo extends Entidad {

	protected int fuerzaDeDisparo;
	protected Texture textura;
	protected Controlador controlador;

	public Disparo() {
		super();
		fuerzaDeDisparo = 0;
		textura = null;
	}

	public Disparo(Vector2 posicion, Vector2 velocidad, int fuerzaDeDisparo, Texture textura){
		super(posicion, velocidad, velocidad.angle());
		this.fuerzaDeDisparo = fuerzaDeDisparo;
		this.textura = textura;
	}

	public Disparo(Vector2 posicion, Vector2 velocidad, int fuerzaDeDisparo, Texture textura, Controlador controlador) {
		super(posicion, velocidad, velocidad.angle());
		this.fuerzaDeDisparo = fuerzaDeDisparo;
		this.textura = textura;
		this.controlador = controlador;
	}

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

	public void setFuerzaDeDisparo(int fuerzaDeDisparo) {
		this.fuerzaDeDisparo = fuerzaDeDisparo;
	}

	public void setTextura(Texture textura) {
		this.textura = textura;
	}

	public void setControladorDisparo(Controlador c) {
		controlador = c;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0)) {
			eliminar();
		}
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}
	
}
