package edu.uns.galaxian.entidades.equipamiento;

import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class EscudoNulo extends Escudo{
 
	public int proteger(Enemigo enemigo) {
		return enemigo.getColisionDamage();
	}
	
	public int proteger(Jugador jugador) {
		return jugador.getColisionDamage();
	}
}
