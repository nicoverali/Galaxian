package edu.uns.galaxian.entidades.autonoma;

public interface FabricaEnemigos {

	public Enemigo getEnemigoComun(int xPos, int yPos);
	
	public Enemigo getEnemigoKamikaze(int xPos, int yPos);
	
}
