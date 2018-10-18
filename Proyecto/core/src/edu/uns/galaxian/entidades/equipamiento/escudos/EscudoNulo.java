package edu.uns.galaxian.entidades.equipamiento.escudos;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public class EscudoNulo implements Escudo{

	public float proteger(Enemigo enemigo) {
		return 0;
	}

	public float proteger(Disparo disparo) {
		return 0;
	}
}
