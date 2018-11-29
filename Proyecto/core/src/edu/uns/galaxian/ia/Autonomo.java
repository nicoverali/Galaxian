package edu.uns.galaxian.ia;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.juego.GameObject;

public interface Autonomo extends GameObject {

	/**
	 * Cambia la inteligencia actual por una nueva
	 * de manera inmediata
	 * @param TareaIA Nueva inteligencia
	 */
	void  setTareaInteligencia(Tarea TareaIA);

	/**
	 * Modifica la velocidad actual del autonomo
	 * @param velocidad Nueva velocidad del autonomo
	 */
	void setVelocidad(Vector2 velocidad);

	/**
	 * Modifica la posicion actual del autonomo
	 * @param posicion Nueva posicion del autonomo
	 */
	void setPosicion(Vector2 posicion);

	/**
	 * Modifica la rotacion actual del autonomo
	 * @param rotacion Nueva rotacion del autonomo
	 */
	void setRotacion(float rotacion);
}