package edu.uns.galaxian.entidades.autonoma.ia;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;

public class InteligenciaAleatoria implements InteligenciaArtificial {

	public void pensar(Entidad estado) {
		float posY = estado.getPosicion().y - 1 ;
		float posX = (float) Math.abs((estado.getPosicion().x + 10*Math.sin(posY/35)));
		Vector2 nuevaPos = new Vector2(posX,posY);
		estado.setPosicion(nuevaPos);
		// TODO Esto es solamente de desarrollo, para que los enemigos puedan seguir disparando sin su ControladorEnemigo
		((Enemigo)estado).disparar();
	}

}