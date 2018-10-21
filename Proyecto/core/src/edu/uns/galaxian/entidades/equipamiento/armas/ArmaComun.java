package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparo;

public class ArmaComun<T extends Disparo> implements Arma<T> {

	private static final long CADENCIA = 500;
	private static final int FUERZA = 35;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static final String TEXTURA_DIR = "disparo/jugador/AZUL";
	private FabricaDisparo<T> fabrica;
	private long ultimoDisparo;

	public ArmaComun(FabricaDisparo<T> fabrica) {
		this.fabrica = fabrica;
		this.ultimoDisparo = TimeUtils.millis() - CADENCIA;
	}

	public void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) {
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			controlador.agregarEntidad(fabrica.crearDisparo(posicion, velocidad, anguloDeDisparo, FUERZA, TEXTURA_DIR, controlador));
			ultimoDisparo = TimeUtils.millis();
		}
	}
}
