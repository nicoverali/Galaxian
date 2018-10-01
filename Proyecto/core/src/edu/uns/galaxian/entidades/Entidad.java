package edu.uns.galaxian.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.entidades.status.Status;

public interface Entidad 
{
	/**
	 * Devuelve la altura de la entidad en pixeles.
	 * @return Altura de la entidad en pixeles.
	 */
	public float getAlto();

	/**
	 * Devuelve el ancho de la entidad en pixeles
	 * @return Ancho de la entidad en pixeles.
	 */
	public float getAncho();
	
	/**
	 * Dibuja la entidad en el mapa.
	 * @param batch Batch que se utilizara para dibujar la entidad
	 */
	public void dibujar(SpriteBatch batch);
	
	/**
	 * Actualiza la posicion de la entidad en el mapa.
	 */
	public void actualizar(float d);
	
	/**
	 * Elimina la entidad del juego.
	 */
	public void eliminar();
	
	/**
	 * Retorna el estado actual de la entidad
	 */
	public Status getStatus();
}
