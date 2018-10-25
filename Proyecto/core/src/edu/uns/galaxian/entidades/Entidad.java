package edu.uns.galaxian.entidades;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.Colisionable;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.util.EntidadBatch;

public abstract class Entidad implements Colisionable, GameObject
{
	protected Vector2 posicion;
	protected Vector2 velocidad;
	protected float rotacion;

	public Entidad(Vector2 posicion, Vector2 velocidad, float rotacion){
		this.posicion = posicion;
		this.velocidad = velocidad;
		this.rotacion = rotacion;
	}

	public Entidad(Vector2 posicion, float rotacion){
		this(posicion, new Vector2(0, 0), rotacion);
	}

	public Entidad(){
		this(new Vector2(0, 0), 0);
	}

	/**
	 * Cambia la posicion de la entidad por una nueva.
	 * @param nuevaPosicion Nueva posicion de la entidad
	 */
	public void setPosicion(Vector2 nuevaPosicion){
		posicion = nuevaPosicion;
	}

	/**
	 * Cambia la posicion de la entidad por una nueva.
	 * @param xPos Nueva posicion en X de la entidad
	 * @param yPos Nueva posicion en Y de la entidad
	 */
	public void setPosicion(float xPos, float yPos){
		posicion.set(xPos, yPos);
	}

	/**
	 * Modifica la velocidad actual de la entidad por una nueva.
	 * @param nuevaVelocidad Nueva velocidad de la entidad
	 */
	public void setVelocidad(Vector2 nuevaVelocidad){
		velocidad = nuevaVelocidad;
	}

	/**
	 * Modifica la rotacion actual de la entidad por una nueva.
	 * @param nuevaRotacion Nueva rotacion de la entidad
	 */
	public void setRotacion(float nuevaRotacion){
		rotacion = nuevaRotacion;
		if(rotacion > 360){
			rotacion -= 360;
		}
	}

	/**
	 * Retorna la posicion actual de la entidad.
	 * @return Posicion actual de la entidad
	 */
	public Vector2 getPosicion() {
		return posicion.cpy();
	}

	/**
	 * Retorna la velocidad actual de la entidad.
	 * @return Velocidad actual de la entidad
	 */
	public Vector2 getVelocidad() {
		return velocidad.cpy();
	}

	/**
	 * Retorna la rotacion actual de la entidad.
	 * @return Rotacion actual de la entidad
	 */
	public float getRotacion() {
		return rotacion;
	}

	/**
	 * Dibuja la entidad en el mapa.
	 * @param batch Batch que se utilizara para dibujar la entidad
	 */
	abstract public void dibujar(EntidadBatch batch);

	/**
	 * Actualiza el estado de la entidad.
	 */
	abstract public void actualizar(float delta);

	/**
	 * Elimina la entidad del juego.
	 */
	abstract public void eliminar();

	public GameObject getStatus(){
		return this;
	}
}
