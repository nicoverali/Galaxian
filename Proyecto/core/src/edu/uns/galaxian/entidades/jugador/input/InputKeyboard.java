package edu.uns.galaxian.entidades.jugador.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;

public class InputKeyboard implements ProcesadorInput {

	private static final int IZQUIERDA = -1;
	private static final int CENTRO = 0;
	private static final int DERECHA = 1;

	public int getXAxis() {
		int leftKey = Gdx.input.isKeyPressed(Keys.LEFT) ? IZQUIERDA : CENTRO;
		int rightKey = Gdx.input.isKeyPressed(Keys.RIGHT) ? DERECHA : CENTRO;
		return leftKey + rightKey;
	}

	public boolean sePresionoDisparar() {
		return Gdx.input.isKeyPressed(Input.Keys.SPACE);
	}

}