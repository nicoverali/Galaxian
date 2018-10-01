package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;

public interface Nave {
	
	public Arma getArma();
	
	public Escudo getEscudo();
	
	public int getVidaMax();
	
	public float getVelocidad();
	
	public float getRotacionInicial();
	
}
