package edu.uns.galaxian.ia.inteligencias;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.ia.InteligenciaArtificial;

public class InteligenciaAleatoria<T extends Autonomo> implements InteligenciaArtificial<T> {

	private T autonomo;

	public InteligenciaAleatoria(T autonomo){
		this.autonomo = autonomo;
	}

	public void pensar(float delta) {
		float posY = autonomo.getPosicion().y - 1 ;
		float posX = (float) Math.abs((autonomo.getPosicion().x + 10*Math.sin(posY/35)));
		Vector2 nuevaPos = new Vector2(posX,posY);
		autonomo.setPosicion(nuevaPos);
		// TODO Esto es solamente de desarrollo, para que los enemigos puedan seguir disparando sin su ControladorEnemigo
		((Enemigo)autonomo).disparar();
	}

}