package edu.uns.galaxian.entidades.equipamiento.escudos;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public interface Escudo {

	float proteger(Enemigo enemigo);
	
	float proteger(Disparo disparo);
	
}
