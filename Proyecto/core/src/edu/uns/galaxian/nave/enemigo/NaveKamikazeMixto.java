package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.inteligencias.InteligenciaAleatoria;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveKamikazeMixto extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/kamikazeMixto/estandar";

	public NaveKamikazeMixto(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo autonomo) {
		return new InteligenciaAleatoria(autonomo);
	}

	public void aceptarColision(Colisionador colisionador) {
		// TODO Llamar al metodo correspondiente
	}
}





