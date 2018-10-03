package edu.uns.galaxian.entidades.autonoma.enemigo;

import edu.uns.galaxian.controladores.ControladorEnemigo;
import edu.uns.galaxian.entidades.status.StatusVida;

public interface FabricaEnemigos {

	Enemigo getKamikaze(int xPos, int yPos, ControladorEnemigo controlador, StatusVida estadoJugador);

	Enemigo getKamikazeAleatorio(int xPos, int yPos, ControladorEnemigo controlador);

	Enemigo getKamikazeMixto(int xPos, int yPos, ControladorEnemigo controlador, StatusVida estadoJugador);

	Enemigo getArmado(int xPos, int yPos, ControladorEnemigo controlador, StatusVida estadoJugador);

	Enemigo getArmadoDebil(int xPos, int yPos, ControladorEnemigo controlador, StatusVida estadoJugador);
	
}
