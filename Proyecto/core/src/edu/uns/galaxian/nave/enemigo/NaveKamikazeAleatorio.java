package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.inteligencia.enemigo.InteligenciaKamikazeAleatoria;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeAleatorio extends NaveEnemigo{

	private static final String TEXTURA_DIR = "enemigo/kamikazeAleatorio/estandar";
	private static final int BONUS = 15;

	public NaveKamikazeAleatorio(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public Tarea<Enemigo> getTareaAtaque(Enemigo autonomo, Jugador jugador) {
		Blackboard<Enemigo> blackboard = new Blackboard<>(autonomo, jugador);
		return new InteligenciaKamikazeAleatoria<>(blackboard);
	}

}