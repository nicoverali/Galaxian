package edu.uns.galaxian.entidades.equipamiento.armas;

import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public abstract class ArmaTemporal<T extends Disparo> implements Arma<T> {
	
	protected int municion;
	
	public ArmaTemporal(int cantMunicion) {
		municion = cantMunicion;
	}
	
	public boolean quedaMunicion() {
		return municion>0;
	}
	
}