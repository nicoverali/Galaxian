package edu.uns.galaxian.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.Colisionable;
import edu.uns.galaxian.entidades.status.Status;

public interface Entidad extends Colisionable
{
	/**
	 * Devuelve la altura de la entidad en pixeles.
	 * @return Altura de la entidad en pixeles.
	 */
    float getAlto();

	/**
	 * Devuelve el ancho de la entidad en pixeles
	 * @return Ancho de la entidad en pixeles.
	 */
    float getAncho();

	/**
	 * Retorna el estado actual de la entidad
	 */
    Status getStatus();

	/**
	 * Dibuja la entidad en el mapa.
	 * @param batch Batch que se utilizara para dibujar la entidad
	 */
    void dibujar(SpriteBatch batch);

	/**
	 * Actualiza el estado de la entidad.
	 */
    void actualizar(float d);

	/**
	 * Elimina la entidad del juego.
	 */
    void eliminar();
}
