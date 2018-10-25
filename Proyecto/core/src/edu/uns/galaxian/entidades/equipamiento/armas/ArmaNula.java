package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public class ArmaNula<T extends Disparo> implements Arma<T> {

    public void disparar(Vector2 posicion, float anguloDeDisparo, Controlador controlador) throws IllegalStateException {
        // Un arma nula no crea disparos
    }
}
