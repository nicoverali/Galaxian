package edu.uns.galaxian.entidades.inanimadas.disparos.fabrica;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;

public class FabricaDisparoJugador implements FabricaDisparo<DisparoJugador> {
    public DisparoJugador crearDisparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, Texture textura, Controlador controlador) {
        return new DisparoJugador(posicion, velocidad, rotacion, fuerzaDeDisparo, textura, controlador);
    }
}
