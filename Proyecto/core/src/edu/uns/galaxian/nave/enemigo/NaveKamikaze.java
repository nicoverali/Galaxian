package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaKamikaze;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikaze extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikaze/estandar";

	public NaveKamikaze(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, steeringMax);
	}

	public InteligenciaArtificial<Enemigo> getInteligenciaAtaque(Enemigo enemigo, Jugador jugador) {
		return new InteligenciaKamikaze<>(enemigo, jugador);
	}
	public void aceptarColision(Colisionador colisionador) {
		// TODO
	}
}
	




