package edu.uns.galaxian.entidades.equipamiento.armas;

import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public abstract class ArmaInfinita<T extends Disparo> implements Arma<T> {
	
	public boolean quedaMunicion() {
		return true;
	}

}