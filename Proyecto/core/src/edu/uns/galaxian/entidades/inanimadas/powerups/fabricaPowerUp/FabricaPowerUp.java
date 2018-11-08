package edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;

public interface FabricaPowerUp {

	public PowerUp getPowerUp(Vector2 posicion, float rotacion, Controlador controlador);
	
}
