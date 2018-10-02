package edu.uns.galaxian.entidades.equipamiento.armas;

import java.util.Collection;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.inanimadas.Disparo;

// TODO Hacer clase
public class ArmaDisparoDoble implements Arma {

	private static final int DAMAGE=15;
	private static final int VELOCIDAD=100;

	public void setDisparoModelo(Disparo modelo){

	}

	@Override
	public Collection<Disparo> disparar(Vector2 posicion, float anguloDeDisparo) throws IllegalStateException {
		return null;
	}

}
