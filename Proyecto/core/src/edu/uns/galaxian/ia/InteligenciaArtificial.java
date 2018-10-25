package edu.uns.galaxian.ia;

import edu.uns.galaxian.ia.autonomo.Autonomo;

public interface InteligenciaArtificial<T extends Autonomo> {

	/**
	 * Actualiza el autonomo controlado por
	 * la inteligencia
	 * @param delta DeltaTime
	 */
	void pensar(float delta);
	
}
