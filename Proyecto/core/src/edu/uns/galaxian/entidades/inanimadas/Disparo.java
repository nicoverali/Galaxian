package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.status.Status;
import edu.uns.galaxian.entidades.status.StatusMutable;

public abstract class Disparo implements Entidad {

	protected int damage;
	protected StatusMutable status;
	protected Texture textura;
	private ControladorDisparo controlador;

	public Disparo() {
		damage = 0;
		status = new StatusMutable();
		textura = null;
	}

	public Disparo(Vector2 posicion, Vector2 velocidad, int damage, Texture textura){
		float rotacion  = velocidad.cpy().nor().x * MathUtils.radiansToDegrees;
		this.damage = damage;
		this.textura = textura;
		this.status = new StatusMutable(posicion, velocidad, rotacion);
	}

	public Disparo(Vector2 posicion, Vector2 velocidad, int damage, Texture textura, ControladorDisparo controlador) {
		float rotacion  = velocidad.cpy().nor().x * MathUtils.radiansToDegrees;
		this.damage = damage;
		this.textura = textura;
		this.status = new StatusMutable(posicion, velocidad, rotacion);
		this.controlador = controlador;
	}

	public abstract Disparo clonar();

	public Status getStatus(){
		return status;
	}

	public float getAlto() {
		return textura.getHeight();
	}

	public float getAncho() {
		return textura.getWidth();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage( int damage) {
		this.damage=damage;
	}

	public void setPosicion(Vector2 posicion){
		status.setPosicion(posicion);
	}

	public void setVelocidad(Vector2 velocidad) {
		status.setVelocidad(velocidad);
	}

	public void setRotacion(float rotacion){
		status.setRotacion(rotacion);
	}

	public void setTextura(Texture textura) {
		this.textura = textura;
	}

	public void setControladorDisparo(ControladorDisparo c) {
		controlador = c;
	}

	public void dibujar(SpriteBatch batch) {
		Vector2 posicion = status.getPosicion();
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar(float delta) {
		Vector2 nuevaPosicion = status.getPosicion().add(status.getVelocidad());
		status.setPosicion(nuevaPosicion);
	}

	public void eliminar() {
		controlador.deregistrar(this);
	}
	
}
