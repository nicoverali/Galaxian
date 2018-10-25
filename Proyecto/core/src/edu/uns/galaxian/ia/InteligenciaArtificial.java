package edu.uns.galaxian.ia;

import edu.uns.galaxian.ia.autonomo.Autonomo;

public interface InteligenciaArtificial<T extends Autonomo> {

	/**
	 * Actualiza el autonomo controlado por
	 * la inteligencia
	 * @param delta DeltaTime
	 */
	void pensar(float delta);

	/**
	 * Transiciona de la inteligencia actual a la nueva inteligencia.
	 * Esto le da la posibilidad a las inteligencias de finalizar algun proceso
	 * antes de cambiar definitivamente a una nueva inteligencia.
	 * Se recomienda utilizar una inteligencia de transicion para
	 * modificar el comportamiento del autonomo al transicionar
	 * @param nuevaInteligencia Nueva inteligencia que tendra el autonomo
	 */
	void transicionar(InteligenciaArtificial<T> nuevaInteligencia);
	
}
