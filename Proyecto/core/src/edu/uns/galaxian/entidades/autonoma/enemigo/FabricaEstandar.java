package edu.uns.galaxian.entidades.autonoma.enemigo;

import edu.uns.galaxian.controladores.ControladorEnemigo;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.nave.enemigo.NaveKamikaze;

public class FabricaEstandar extends FabricaEnemigos {

	public Enemigo getKamikaze(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(60, 200, 20, jugador);
		return new Enemigo(xPos, yPos, nave, controlador);
	}

	public Enemigo getKamikazeAleatorio(float xPos, float yPos, ControladorEnemigo controlador) {
		NaveKamikaze nave = new NaveKamikaze(80, 200, 20, null);
		return new Enemigo(xPos, yPos, nave, controlador);
	}

	public Enemigo getKamikazeMixto(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(70, 200, 20, jugador);
		return new Enemigo(xPos, yPos, nave, controlador);
	}

	public Enemigo getArmado(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(60, 200, 20, jugador);
		return new Enemigo(xPos, yPos, nave, controlador);
	}

	public Enemigo getArmadoDebil(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(80, 200, 20, jugador);
		return new Enemigo(xPos, yPos, nave, controlador);
	}
}
