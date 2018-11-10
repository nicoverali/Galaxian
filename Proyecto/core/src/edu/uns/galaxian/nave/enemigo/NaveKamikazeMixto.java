package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.inteligencia.enemigo.InteligenciaKamikaze;
import edu.uns.galaxian.ia.tareas.inteligencia.enemigo.InteligenciaKamikazeMixto;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeMixto extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikazeMixto/estandar";
	private static final int BONUS = 20;

	public NaveKamikazeMixto(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public Tarea<Enemigo> getTareaAtaque(Enemigo enemigo, Jugador jugador) {
		Blackboard<Enemigo> blackboard = new Blackboard<>(enemigo, jugador);
		return new InteligenciaKamikazeMixto<>(blackboard);
	}

	public void aceptarColision(Visitor colisionador) {
		// TODO Llamar al metodo correspondiente
	}
	
}





