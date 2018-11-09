package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparo;

public class ArmaDisparoUnico<T extends Disparo> extends ArmaTemporal<T> {

	private static final int FUERZA = 35;
	private static final int VELOCIDAD_MAXIMA = 100;
	private static final String TEXTURA_DIR = "disparo/jugador/ROJO";
	private FabricaDisparo<T> fabrica;

	public ArmaDisparoUnico(FabricaDisparo<T> fabrica) {
		super(1);
		this.fabrica = fabrica;
	}

	public void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) {
		if(municion>0){
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			T disparo = fabrica.crearDisparo(posicion, velocidad, anguloDeDisparo, FUERZA, TEXTURA_DIR, controlador);
			controlador.agregarEntidad(disparo);
			municion--;
		}
	}

}