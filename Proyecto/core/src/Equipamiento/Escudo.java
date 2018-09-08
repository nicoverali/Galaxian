package Equipamiento;

import Autonoma.Enemigo;
import Inanimadas.Disparo;

public interface Escudo {

	public float proteger(Enemigo enemigo);
	
	public float proteger(Disparo disparo);
	
}
