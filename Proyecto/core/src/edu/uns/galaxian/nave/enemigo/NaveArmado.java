package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitante;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaArmado;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveArmado extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/armado/estandar";
	private static final int bonus = 10;

	public NaveArmado(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, bonus, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo autonomo, Jugador jugador) {
		return new InteligenciaArmado<>(autonomo, jugador);
	}
	
	public void aceptarColision(Visitante colisionador) {
		// TODO
	}
	
}
