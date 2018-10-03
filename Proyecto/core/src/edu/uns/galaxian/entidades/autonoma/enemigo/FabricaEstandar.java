package edu.uns.galaxian.entidades.autonoma.enemigo;

import edu.uns.galaxian.nave.enemigo.NaveEnemigo;
import edu.uns.galaxian.nave.enemigo.NaveKamikaze;

public class FabricaEstandar implements FabricaEnemigos {


	public Enemigo getKamikaze(int xPos, int yPos) {
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage);
	}

	public Enemigo getKamikazeAleatorio(int xPos, int yPos) {
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage);
	}

	public Enemigo getKamikazeMixto(int xPos, int yPos) {
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage);
	}

	public Enemigo getArmado(int xPos, int yPos) {
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage);
	}

	public Enemigo getArmadoDebil(int xPos, int yPos) {
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage);
	}

	private Enemigo crearEnemigo(int xPos, int yPos, int vidaMaxima, int colisionDamage){
		NaveEnemigo nave = new NaveKamikaze(vidaMaxima,colisionDamage);
		return  new Enemigo(xPos,yPos,nave);
	}
}
