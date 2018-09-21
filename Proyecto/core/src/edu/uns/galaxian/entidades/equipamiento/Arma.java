package edu.uns.galaxian.entidades.equipamiento;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.inanimadas.*;

public interface Arma {
	
	public List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion);
	
}
