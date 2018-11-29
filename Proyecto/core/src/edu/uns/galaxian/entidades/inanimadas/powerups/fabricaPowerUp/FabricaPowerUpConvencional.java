package edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal.CampoDeProteccion;
import edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal.MejoraArma;
import edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal.Misil;
import edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal.PastillaVida;
import edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso.CongelaTiempo;
import edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso.PoderCosmico;

public class FabricaPowerUpConvencional implements FabricaPowerUp {

	public PowerUp getPowerUp(Vector2 posicion, float rotacion, Controlador controlador) {
		Random ran= new Random();
    	int n = ran.nextInt(6);
    	switch(n){
    		case 0: return new PastillaVida(posicion,new Vector2 (0,-2),rotacion,controlador);
    		case 1: return new CampoDeProteccion(posicion,new Vector2 (0,-2),rotacion,controlador);
    		case 2: return new Misil(posicion,new Vector2 (0,-2),rotacion,controlador);
    		case 3: return new MejoraArma(posicion,new Vector2 (0,-2),rotacion,controlador);
    		case 4: return new CongelaTiempo(posicion,new Vector2 (0,-2),rotacion,controlador);
    		case 5: return new PoderCosmico(posicion,new Vector2 (0,-2),rotacion,controlador);
    		default: return null;
    	}
	}

}