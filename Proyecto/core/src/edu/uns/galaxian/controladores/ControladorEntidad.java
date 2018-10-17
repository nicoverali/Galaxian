package edu.uns.galaxian.controladores;

import edu.uns.galaxian.entidades.EntidadBatch;

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
	void dibujar(EntidadBatch batch);
}
