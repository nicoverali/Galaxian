package edu.uns.galaxian.entidades.autonoma;

import edu.uns.galaxian.entidades.*;
import edu.uns.galaxian.entidades.autonoma.ia.*;

public abstract class EntidadAutonoma extends EntidadViva {

	protected InteligenciaArtificial inteligencia;

	// TODO En los metodos que no reciben ia, podria setearse una ia de tipo Nula, en vez de null.
	public EntidadAutonoma(int xPos, int yPos, float factorEscala, int vidaMaxima, InteligenciaArtificial ia) {
		super(xPos, yPos, factorEscala, vidaMaxima);
		inteligencia = ia;
	}

	public EntidadAutonoma(int xPos, int yPos, float factorEscala, int vidaMaxima){
		super(xPos, yPos, factorEscala, vidaMaxima);
	}

	public EntidadAutonoma(int xPos, int yPos, int vidaMaxima){
		super(xPos, yPos, 1, vidaMaxima);
	}

	/**
	 * Setea la inteligencia de la entidad autonoma.
	 * @param ia nueva Inteligencia Artificial que tendra la entidad autonoma.
	 */
	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}
	
	/**
	 * Devuelve la inteligencia artificial que la entidad autonoma posee actualmente.
	 * @return Inteligencia Artificial de la entidad autonoma.
	 */
	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}
	
}
