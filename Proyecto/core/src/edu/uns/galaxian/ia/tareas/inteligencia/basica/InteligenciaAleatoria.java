package edu.uns.galaxian.ia.tareas.inteligencia.basica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class InteligenciaAleatoria<T extends Autonomo> extends Tarea<T> {

	public InteligenciaAleatoria(Blackboard<T> blackboard) {
		super(blackboard);
	}

	public InteligenciaAleatoria() {
	}

	public boolean realizar(float delta) {
		T autonomo = blackboard.getAutonomo();
		float posY = autonomo.getPosicion().y - 1 ;
		float posX = (float) Math.abs((autonomo.getPosicion().x + 10*Math.sin(posY/35)));
		Vector2 nuevaPos = new Vector2(posX,posY);
		autonomo.setPosicion(nuevaPos);
		// TODO Esto es solamente de desarrollo, para que los enemigos puedan seguir disparando sin su ControladorEnemigo
		((Enemigo)autonomo).disparar();
		return true;
	}
}