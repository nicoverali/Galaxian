package edu.uns.galaxian.entidades.equipamiento.escudos;

import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

// REVIEW Con la nueva implementacion de entidades que setean sus disparos, sigue funcionando la prog. dinamica ?
public class FabricaArmas {

	private Arma armaComun;
	private Arma armaDisparoDoble;

	public Arma getArmaComun(Disparo modelo) {
		Arma nueva = (armaComun==null) ? new ArmaComun(modelo) : armaComun;
		return nueva;
	}
	
	public Arma getArmaDisparoDoble() {
		Arma nueva = (armaComun==null) ? new ArmaDisparoDoble() : armaDisparoDoble;
		return nueva;
	}
	
}
