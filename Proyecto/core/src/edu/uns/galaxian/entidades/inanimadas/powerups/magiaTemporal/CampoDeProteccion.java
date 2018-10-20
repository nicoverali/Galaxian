package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class CampoDeProteccion extends PowerUp {

	public CampoDeProteccion(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura=new Texture(Gdx.files.internal("./Power-ups/shield_green.png"));
	}

	@Override
	public void efectoJugador(Jugador jugador) {
		// TODO pensar
		
	}

}
