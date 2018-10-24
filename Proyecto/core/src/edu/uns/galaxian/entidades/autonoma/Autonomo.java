package edu.uns.galaxian.entidades.autonoma;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.ia.*;
import edu.uns.galaxian.entidades.status.GameObject;

public interface Autonomo extends GameObject {

	/**
	 * Retorna la inteligencia actual
	 */
    InteligenciaArtificial getInteligencia();
		
	/**
	 * Cambia la inteligencia actual por una nueva
	 */
    void setInteligencia(InteligenciaArtificial ia);
}
