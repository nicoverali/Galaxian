package edu.uns.galaxian.entidades.equipamiento.armas;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.inanimadas.*;

public interface Arma {

	void setDisparoModelo(Disparo modelo);
	List<Disparo> disparar(int xPos, int yxPos, Vector2 direccion);
	
}
