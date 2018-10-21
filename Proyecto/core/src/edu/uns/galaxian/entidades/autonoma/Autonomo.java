package edu.uns.galaxian.entidades.autonoma;

import edu.uns.galaxian.entidades.autonoma.ia.*;

public interface Autonomo {

	/**
	 * Retorna la inteligencia actual
	 */
    InteligenciaArtificial getInteligencia();
		
	/**
	 * Cambia la inteligencia actual por una nueva
	 */
    void setInteligencia(InteligenciaArtificial ia);
	
}
