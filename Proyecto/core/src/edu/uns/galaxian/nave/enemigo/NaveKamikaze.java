package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.inteligencia.enemigo.InteligenciaKamikaze;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikaze extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikaze/estandar";
	private static final int BONUS = 10;

	public NaveKamikaze(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public Tarea<Enemigo> getTareaAtaque(Enemigo enemigo, Jugador jugador) {
		Blackboard<Enemigo> blackboard = new Blackboard<>(enemigo, jugador);
		return new InteligenciaKamikaze<>(blackboard);
	}
	
	public void aceptarColision(Visitor colisionador) {
		// TODO
	}
	
}
	




