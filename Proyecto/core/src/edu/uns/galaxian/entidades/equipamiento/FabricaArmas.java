package edu.uns.galaxian.entidades.equipamiento;

import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class FabricaArmas {

	private Arma armaComun;
	private Arma armaDisparoDoble;
	
	public Arma getArmaComun(Disparo modelo) {
		Arma nueva = (armaComun==null)? new ArmaComun(modelo) : armaComun;
		return nueva;
	}
	
	public Arma getArmaDisparoDoble() {
		Arma nueva = (armaComun==null)? new ArmaDisparoDoble() : armaDisparoDoble;
		return nueva;
	}
	
}
