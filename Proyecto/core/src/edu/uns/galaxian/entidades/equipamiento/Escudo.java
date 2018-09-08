package edu.uns.galaxian.entidades.equipamiento;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public interface Escudo {

	public float proteger(Enemigo enemigo);
	
	public float proteger(Disparo disparo);
	
}
