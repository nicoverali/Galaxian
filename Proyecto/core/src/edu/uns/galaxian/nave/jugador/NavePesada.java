package edu.uns.galaxian.nave.jugador;

import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.util.enums.Color;

public class NavePesada extends NaveJugador {

	private static final int VIDA_MAXIMA = 400;
	private static final int VELOCIDAD_MAXIMA = 250;
	private static final String TEXTURA_DIR = "jugador/%s/navePesada";

	public NavePesada(Color colorNave){
		super(String.format(TEXTURA_DIR, colorNave.name()), colorNave);
	}

	public int getVidaMax() {
		return VIDA_MAXIMA;
	}

	public float getVelocidadMax() {
		return VELOCIDAD_MAXIMA;
	}
}
