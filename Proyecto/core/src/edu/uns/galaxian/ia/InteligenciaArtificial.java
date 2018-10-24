package edu.uns.galaxian.ia;

import edu.uns.galaxian.entidades.autonoma.Autonomo;

public interface InteligenciaArtificial<T extends Autonomo> {

	/**
	 * Actualiza el autonomo controlado por
	 * la inteligencia
	 * @param delta DeltaTime
	 */
	void pensar(float delta);
	
}
