package edu.uns.galaxian.juego;

import com.badlogic.gdx.math.Vector2;

public interface GameObject {

	/**
	 * Retorna la posicion actual.
	 * @return Posicion actual
	 */
    Vector2 getPosicion();

	/**
	 * Retorna la velocidad actual.
	 * @return Velocidad actual
	 */
    Vector2 getVelocidad();

	/**
	 * Retorna la rotacion actual en grados.
	 * El eje horizontal de la pantalla en sentido derecho, se considera grado 0.
	 * @return Rotacion actual en grados
	 */
    float getRotacion();
}
