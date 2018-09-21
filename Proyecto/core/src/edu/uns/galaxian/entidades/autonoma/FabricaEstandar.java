package edu.uns.galaxian.entidades.autonoma;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class FabricaEstandar implements FabricaEnemigos {

	public Enemigo getEnemigoComun(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal("enemigos/enemyRed3.png"));
		Enemigo nuevo = new Enemigo(xPos,yPos,200,textura);
		return nuevo;
	}

	public Enemigo getEnemigoKamikaze(int xPos, int yPos) {
		Texture textura = new Texture(Gdx.files.internal("enemigos/enemyRed3.png"));
		Enemigo nuevo = new Enemigo(xPos,yPos,200,textura);
		return nuevo;
	}

}
