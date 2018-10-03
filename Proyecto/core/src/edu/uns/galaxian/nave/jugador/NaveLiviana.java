package edu.uns.galaxian.nave.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import edu.uns.galaxian.util.enums.Color;

public class NaveLiviana extends NaveJugador {

	private static final int VELOCIDAD_MAXIMA = 400;
	private static final int VIDA_MAXIMA = 100;
	private static final String TEXTURA_DIR = "./jugador/%s/naveLiviana.png";

	public NaveLiviana(Color colorNave){
		String direccionCompleta = String.format(TEXTURA_DIR, colorNave.name());
		textura = new Texture(Gdx.files.internal(direccionCompleta));
	}

	public int getVidaMax() {
		return VIDA_MAXIMA;
	}

	public float getVelocidadMax() {
		return VELOCIDAD_MAXIMA;
	}

	public float getRotacionInicial() {
		return 90f;
	}
}
