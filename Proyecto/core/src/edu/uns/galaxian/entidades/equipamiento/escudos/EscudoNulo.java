package edu.uns.galaxian.entidades.equipamiento.escudos;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class EscudoNulo implements Escudo{

	@Override
	public float proteger(Enemigo enemigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float proteger(Disparo disparo) {
		// TODO Auto-generated method stub
		return 0;
	}
}