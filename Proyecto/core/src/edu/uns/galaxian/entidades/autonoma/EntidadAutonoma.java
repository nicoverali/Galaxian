package edu.uns.galaxian.entidades.autonoma;

import edu.uns.galaxian.entidades.*;
import edu.uns.galaxian.entidades.autonoma.ia.*;

public abstract class EntidadAutonoma implements EntidadColisionable {

	private InteligenciaArtificial inteligencia;
	
	/**
	 * Setea la inteligencia de la entidad aut�noma.
	 * @param ia nueva Inteligencia Artificial que tendra la entidad aut�noma.
	 */
	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}
	
	/**
	 * Devuelve la inteligencia artificial que la entidad aut�noma posee actualmente.
	 * @return Inteligencia Artificial de la entidad aut�noma.
	 */
	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}
	
}
