package edu.uns.galaxian.controladores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ControladorEntidad {

	/**
	 * Actualiza el estado de las entidades que estan bajo su control.
	 * @param delta Tiempo desde el ultimo frame
	 */
	void actualizarEstado(float delta);
	
	/**
	 * Dibuja todas las entidades que estan bajo su control.
	 * @param batch Batch para dibujar las entidades
	 */
	void dibujar(SpriteBatch batch);
}
