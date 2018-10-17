package edu.uns.galaxian.entidades.equipamiento.armas;
import java.util.Collection;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.inanimadas.*;

public interface Arma<T extends Disparo> {

	/**
	 * Produce nuevos disparos a partir de la posicion y el angulo de disparo proveido.
	 * @param posicion Posicion donde se deben producir los disparos
	 * @param anguloDeDisparo Angulo con el que se produciran los disparos
	 * @return Coleccion de disparos producidos
	 * @throws IllegalStateException Si el arma no tiene un disparo modelo
	 */
	public Collection<T> disparar(Vector2 posicion, float anguloDeDisparo) throws IllegalStateException;
	
}
