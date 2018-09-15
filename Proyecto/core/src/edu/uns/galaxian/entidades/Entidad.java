package edu.uns.galaxian.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract  class Entidad {

	protected Vector2 posicion;
	protected float factorEscala;

	/**
	 * Crea una nueva entidad con la posicion y el factor de escala dados.
	 * @param xPos Posicion en X de la entidad
	 * @param yPos Posicion en Y de la entidad
	 * @param factorEscala Factor de escala de la entidad
	 */
	public Entidad(int xPos, int yPos, float factorEscala){
		this.posicion = new Vector2(xPos, yPos);
		this.factorEscala = Math.abs(factorEscala);
	}

	/**
	 * Crea una nueva entidad con la posicion dada. El factor de escala sera 1.
	 * @param xPos Posicion en X de la entidad
	 * @param yPos Posicion en Y de la entidad
	 */
	public Entidad(int xPos, int yPos){
		posicion = new Vector2(xPos, yPos);
		factorEscala = 1;
	}

	/**
	 * Crea una nueva entidad con una posicion por defecto y el factor de escala asignado a 1
	 */
	public Entidad(){
		posicion = Vector2.Zero;
		factorEscala = 1;
	}

	/**
	 * Setea la posicion de la entidad con la nueva posicion pasada como parametro.
	 * @param nuevaPos Nueva posicion de la entidad representada en un vector
	 * @return Posicion anterior de la entidad
	 */
	public Vector2 setPosicion(Vector2 nuevaPos){
		Vector2 temp = posicion;
		posicion = nuevaPos;
		return temp;
	}

	/**
	 * Setea la posicion de la entidad con la nueva posicion pasada como parametro.
	 * @param xPos Valor en x de la nueva posicion de la entidad
	 * @param yPos Valor en y de la nueva posicion de la entidad
	 * @return Posicion anterior de la entidad
	 */
	public Vector2 setPosicion(int xPos, int yPos){
		Vector2 temp = posicion;
		posicion = new Vector2(xPos, yPos);
		return temp;
	}
	
	/**
	 * Devuelve la posicion actual de la entidad en el mapa.
	 * @return Posicion actual de la entidad.
	 */
	public Vector2 getPosicion(){
		return posicion.cpy();
	}

	/**
	 * Setea el factor de escala de la entidad.
	 * @param factorEscala Nuevo factor de escala
	 */
	public void setFactorEscala(float factorEscala){
		this.factorEscala = Math.abs(factorEscala);
	}
	
	/**
	 * Dibuja la entidad en el mapa.
	 * @param batch Batch que se utilizara para dibujar la entidad
	 */
	public abstract void dibujar(SpriteBatch batch);
	
	/**
	 * Actualiza la posicion de la entidad en el mapa.
	 */
	public abstract void actualizar();
	
	/**
	 * Elimina la entidad del juego.
	 */
	public abstract void eliminar();
}
