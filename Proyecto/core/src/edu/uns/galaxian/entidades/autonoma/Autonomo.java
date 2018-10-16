package edu.uns.galaxian.entidades.autonoma;

import edu.uns.galaxian.entidades.autonoma.ia.*;

public interface Autonomo {

	/**
	 * Retorna la inteligencia del enemigo
	 */
    InteligenciaArtificial getInteligencia();
		
	/**
	 * Setea la inteligencia al enemigo
	 */
    void setInteligencia(InteligenciaArtificial i);
	
}
