package edu.uns.galaxian.entidades.autonoma.ia;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.status.StatusMutable;

public class InteligenciaAleatoria implements InteligenciaArtificial {

	public void pensar(StatusMutable estado) {
		float posY = estado.getPosicion().y - 1 ;
		float posX = (float) (estado.getPosicion().x + 10*Math.sin(posY/35));
		Vector2 nuevaPos = new Vector2(posX,posY);
		estado.setPosicion(nuevaPos);
	}

}