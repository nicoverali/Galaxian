package edu.uns.galaxian.entidades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface Entidad {
	
	/**
	 * Setea la posici�n del jugador con la nuevaPos pasada como parametro.
	 * @param nuevaPos Nueva posici�n de jugador.
	 * @return
	 */
	public Vector2 setPosicion(Vector2 nuevaPos);
	
	/**
	 * Devuelve la posici�n actual de la entidad en el mapa.
	 * @return Posicion actual de la entidad.
	 */
	public Vector2 getPosicion();
	
	/**
	 * Dibuja la entidad en el mapa.
	 * @param batch
	 */
	public void dibujar(SpriteBatch batch);
	
	/**
	 * Actualiza la posici�n del jugador en el mapa.
	 */
	public void actualizar();
	
	/**
	 * Elimina la entidad del juego.
	 */
	public void eliminar();
}
