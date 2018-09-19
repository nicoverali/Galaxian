package edu.uns.galaxian.entidades.equipamiento;

public class FabricaDeArmas {

	private Arma armaComun;
	private Arma armaDisparoDoble;
	
	public Arma getArmaComun() {
		Arma nueva = (armaComun==null)? new ArmaComun() : armaComun;
		return nueva;
	}
	
	public Arma getArmaDisparoDoble() {
		Arma nueva = (armaComun==null)? new ArmaDisparoDoble() : armaDisparoDoble;
		return nueva;
	}
	
}
