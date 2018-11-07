package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaKamikaze;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikaze extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikaze/estandar";
	private static final int bonus = 10;

	public NaveKamikaze(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, bonus, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo enemigo, Jugador jugador) {
		return new InteligenciaKamikaze<>(enemigo, jugador);
	}
	
	public void aceptarColision(Visitor colisionador) {
		// TODO
	}
	
}
	




