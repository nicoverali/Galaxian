package edu.uns.galaxian.ia.autonomo;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.ia.InteligenciaArtificial;

public interface Autonomo extends GameObject {

	/**
	 * Retorna la inteligencia actual
	 */
    InteligenciaArtificial getInteligencia();
		
	/**
	 * Cambia la inteligencia actual por una nueva
	 * de manera inmediata
	 * @param ia Nueva inteligencia
	 */
    void setInteligencia(InteligenciaArtificial ia);

	/**
	 * Cambia la inteligencia actual por una nueva
	 * realizando la transicion correspondiente de la
	 * actual a la nueva.
	 * @param ia Nueva inteligencia
	 */
	void transicionarInteligencia(InteligenciaArtificial ia);

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
