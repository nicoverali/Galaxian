package edu.uns.galaxian.entidades.inanimadas.disparos.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;

public class FabricaDisparoEnemigo implements FabricaDisparo<DisparoEnemigo> {
    public DisparoEnemigo crearDisparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador) {
        return new DisparoEnemigo(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador);
    }
}
