package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.inteligencia.enemigo.InteligenciaArmado;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveArmadoDebil extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/armadoDebil/estandar";
	private static final int BONUS = 5;

	public NaveArmadoDebil(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public Tarea<Enemigo> getTareaAtaque(Enemigo autonomo, Jugador jugador) {
		Blackboard<Enemigo> blackboard = new Blackboard<>(autonomo, jugador);
		return new InteligenciaArmado<>(blackboard);
	}
}