package edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class CongelaTiempo extends PowerUp {

	public CongelaTiempo(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas().findRegion("powerup/congelaTiempo");
	}

	@Override
	public void efectoJugador(Jugador jugador) {
		// TODO pensar
		
	}

}
