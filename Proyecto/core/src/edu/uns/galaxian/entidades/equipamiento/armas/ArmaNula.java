package edu.uns.galaxian.entidades.equipamiento.armas;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

import java.util.ArrayList;
import java.util.Collection;

public class ArmaNula implements Arma {

    @Override
    public void setDisparoModelo(Disparo modelo) {
        // Do nothing
    }

    @Override
    public Collection<Disparo> disparar(Vector2 posicion, float anguloDeDisparo) throws IllegalStateException {
        return new ArrayList<>(0);
    }
}
