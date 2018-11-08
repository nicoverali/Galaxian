package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaKamikazeAleatoria;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeAleatorio extends NaveEnemigo{

	private static final String TEXTURA_DIR = "enemigo/kamikazeAleatorio/estandar";
	private static final int BONUS = 15;

	public NaveKamikazeAleatorio(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo autonomo, Jugador jugador) {
		return new InteligenciaKamikazeAleatoria<>(autonomo, jugador);
	}
	
	public void aceptarColision(Visitor colisionador) {
		// TODO
	}
	
}
