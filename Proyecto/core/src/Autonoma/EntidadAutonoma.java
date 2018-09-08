package Autonoma;

import Entidades.*;
import IA.*;

public abstract class EntidadAutonoma implements EntidadColisionable {

	private InteligenciaArtificial inteligencia;
	
	/**
	 * Setea la inteligencia de la entidad autónoma.
	 * @param ia nueva Inteligencia Artificial que tendra la entidad autónoma.
	 */
	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}
	
	/**
	 * Devuelve la inteligencia artificial que la entidad autónoma posee actualmente.
	 * @return Inteligencia Artificial de la entidad autónoma.
	 */
	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}
	
}
