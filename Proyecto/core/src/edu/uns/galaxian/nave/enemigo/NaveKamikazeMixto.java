package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaKamikazeMixto;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeMixto extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikazeMixto/estandar";
	private static final int BONUS = 20;

	public NaveKamikazeMixto(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, BONUS, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo autonomo, Jugador jugador) {
		return new InteligenciaKamikazeMixto<>(autonomo, jugador);
	}

	public void aceptarColision(Visitor colisionador) {
		// TODO Llamar al metodo correspondiente
	}
	
}





