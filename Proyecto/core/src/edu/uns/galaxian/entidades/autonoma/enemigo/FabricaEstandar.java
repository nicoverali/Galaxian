package edu.uns.galaxian.entidades.autonoma.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class FabricaEstandar implements FabricaEnemigos {

	private static final String DIR = "./enemigos/";

	public Enemigo getKamikaze(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal(DIR + "kamikaze/estandar.png"));
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}

	public Enemigo getKamikazeAleatorio(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal(DIR + "kamikaze_aleatorio/estandar.png"));
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}

	public Enemigo getKamikazeMixto(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal(DIR + "kamikaze_mixto/estandar.png"));
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}

	public Enemigo getArmado(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal(DIR + "armado/estandar.png"));
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}

	public Enemigo getArmadoDebil(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal(DIR + "armado_debil/estandar.png"));
		int vidaMaxima = 100;
		int colisionDamage = 50;
		return crearEnemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}

	private Enemigo crearEnemigo(int xPos, int yPos, int vidaMaxima, int colisionDamage, Texture textura){
		return new Enemigo(xPos, yPos, vidaMaxima, colisionDamage, textura);
	}
}
