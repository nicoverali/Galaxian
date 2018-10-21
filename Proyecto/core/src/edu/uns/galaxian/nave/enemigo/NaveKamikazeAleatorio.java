package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaAleatoria;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeAleatorio extends NaveEnemigo{

	private static final String TEXTURA_DIR = "enemigo/kamikazeAleatorio/estandar";

	public NaveKamikazeAleatorio(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque() {
		return new InteligenciaAleatoria();
	}

	public void aceptarColision(Colisionador colisionador) {
		// TODO
	}
}
