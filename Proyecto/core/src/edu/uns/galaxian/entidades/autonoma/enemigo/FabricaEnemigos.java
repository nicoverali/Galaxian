package edu.uns.galaxian.entidades.autonoma.enemigo;

public interface FabricaEnemigos {

	Enemigo getKamikaze(int xPos, int yPos);

	Enemigo getKamikazeAleatorio(int xPos, int yPos);

	Enemigo getKamikazeMixto(int xPos, int yPos);

	Enemigo getArmado(int xPos, int yPos);

	Enemigo getArmadoDebil(int xPos, int yPos);
	
}
