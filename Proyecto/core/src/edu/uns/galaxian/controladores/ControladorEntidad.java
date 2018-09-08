package edu.uns.galaxian.controladores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ControladorEntidad {

	/**
	 * Actualiza el estado de las entidades que estan bajo su control.
	 */
	public void actualizarEstado();
	
	/**
	 * Dibuja todas las entidades que estan bajo su control.
	 * @param batch
	 */
	public void dibujar(SpriteBatch batch);
	
}
