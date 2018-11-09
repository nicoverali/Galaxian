package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparo;

public class ArmaDisparoLimitado<T extends Disparo> implements Arma<T> {

	private static final int FUERZA = 35;
	private static final int VELOCIDAD_MAXIMA = 100;
	private static final String TEXTURA_DIR = "disparo/jugador/ROJO";
	private FabricaDisparo<T> fabrica;
	private volatile int maxDisparos;
	private volatile int cantDisparos;

	public ArmaDisparoLimitado(FabricaDisparo<T> fabrica, int maxDisparos) {
		this.fabrica = fabrica;
		this.maxDisparos = maxDisparos;
		cantDisparos = 0;
	}

	public void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) {
		if(cantDisparos<maxDisparos){
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			T disparo = fabrica.crearDisparo(posicion, velocidad, anguloDeDisparo, FUERZA, TEXTURA_DIR, controlador);
			controlador.agregarEntidad(disparo);
			cantDisparos++;
		}
	}
}