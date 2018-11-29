package edu.uns.galaxian.ia.tareas.inteligencia.basica;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class InteligenciaDeOnda<T extends Autonomo> extends Tarea<T> {

	public InteligenciaDeOnda(Blackboard<T> blackboard) {
		super(blackboard);
	}

	public boolean realizar(float delta) {
		T autonomo = blackboard.getAutonomo();
		float posX = autonomo.getPosicion().x + 1 ;
		float posY = (float) Math.abs((autonomo.getPosicion().y + 2*Math.sin(posX/40)));
		Vector2 nuevaPos = new Vector2(posX,posY);
		autonomo.setPosicion(nuevaPos);
		return true;
	}
}