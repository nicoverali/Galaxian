package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparo;

public class ArmaDisparoDoble<T extends Disparo> implements Arma<T> {

	private static final long CADENCIA = 300;
	private static final int FUERZA = 35;
	private static final int VELOCIDAD_MAXIMA = 150;
	private static final String TEXTURA_DIR = "disparo/enemigo/comun";
	private FabricaDisparo<T> fabrica;
	private long ultimoDisparo;

	public ArmaDisparoDoble(FabricaDisparo<T> fabrica) {
		this.fabrica = fabrica;
		this.ultimoDisparo = TimeUtils.millis() - CADENCIA;
	}

	public void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) {
		if(TimeUtils.timeSinceMillis(ultimoDisparo) > CADENCIA){
			Vector2 velocidad = new Vector2(1,0).rotate(anguloDeDisparo).setLength2(VELOCIDAD_MAXIMA);
			Vector2 posicion1 = posicion.cpy().add(10,0);
			Vector2 posicion2 = posicion.cpy().add(-10,0);
			controlador.agregarEntidad(fabrica.crearDisparo(posicion1, velocidad, anguloDeDisparo, FUERZA, TEXTURA_DIR, controlador));
			controlador.agregarEntidad(fabrica.crearDisparo(posicion2, velocidad, anguloDeDisparo, FUERZA, TEXTURA_DIR, controlador));
			ultimoDisparo = TimeUtils.millis();
		}
	}

}
