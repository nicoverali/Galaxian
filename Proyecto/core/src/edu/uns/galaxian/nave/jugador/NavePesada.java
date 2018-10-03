package edu.uns.galaxian.nave.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import edu.uns.galaxian.util.enums.Color;

public class NavePesada extends NaveJugador {

	private static final int VIDA_MAXIMA = 250;
	private static final int VELOCIDAD_MAXIMA = 140;
	private static final String TEXTURA_DIR = "./jugador/%s/navePesada.png";

	public NavePesada(Color colorNave){
		String direccionCompleta = String.format(TEXTURA_DIR, colorNave.name());
		textura = new Texture(Gdx.files.internal(direccionCompleta));
	}

	@Override
	public int getVidaMax() {
		return VIDA_MAXIMA;
	}

	@Override
	public float getVelocidadMax() {
		return VELOCIDAD_MAXIMA;
	}

	@Override
	public float getRotacionInicial() {
		return 90f;
	}
}
