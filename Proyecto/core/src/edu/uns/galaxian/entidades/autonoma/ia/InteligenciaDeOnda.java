package edu.uns.galaxian.entidades.autonoma.ia;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.Entidad;

public class InteligenciaDeOnda implements InteligenciaArtificial {

	public void pensar(Entidad estado) {
		float posX = estado.getPosicion().x + 1 ;
		float posY = (float) Math.abs((estado.getPosicion().y + 2*Math.sin(posX/40)));
		Vector2 nuevaPos = new Vector2(posX,posY);
		estado.setPosicion(nuevaPos);
	}
	
}
