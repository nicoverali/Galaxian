package edu.uns.galaxian.nave.enemigo;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.ia.inteligencias.InteligenciaAleatoria;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.nave.NaveEnemigo;

public class NaveArmadoDebil extends NaveEnemigo {

	private static final String TEXTURA_DIR = "enemigo/armadoDebil/estandar";

	public NaveArmadoDebil(int vidaMax, float velocidadMax, float steeringMax, int fuerzaColision) {
		super(TEXTURA_DIR, vidaMax, velocidadMax, fuerzaColision, steeringMax);
	}

	public InteligenciaArtificial getInteligenciaAtaque(Enemigo autonomo) {
		return new InteligenciaAleatoria(autonomo);
	}
	public void aceptarColision(Colisionador colisionador) {
		// TODO
	}
}
