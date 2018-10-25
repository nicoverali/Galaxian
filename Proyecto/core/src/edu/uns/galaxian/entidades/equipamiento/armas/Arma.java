package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public interface Arma<T extends Disparo> {

	/**
	 * Produce nuevos disparos a partir de la posicion y el angulo de disparo proveido.
	 * Utiliza el Controlador recibido para registrar los nuevos disparos.
	 * @param posicion Posicion donde se deben producir los disparos
	 * @param anguloDeDisparo Angulo con el que se produciran los disparos
	 * @param controlador Controlador al cual perteneceran los disparos creados
	 * @throws IllegalStateException Si el arma no tiene un disparo modelo
	 */
	void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) throws IllegalStateException;
	
}
