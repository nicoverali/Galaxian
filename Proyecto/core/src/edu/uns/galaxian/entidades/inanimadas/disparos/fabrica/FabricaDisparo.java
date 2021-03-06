package edu.uns.galaxian.entidades.inanimadas.disparos.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public interface FabricaDisparo<T extends Disparo> {

    /**
     * Genera un nuevo disparo del tipo de la fabrica.
     * Si bien se pide un Controlador para crear el disparo, no
     * se agrega el disparo al controlador.
     * @param posicion Posicion del disparo
     * @param velocidad Velocidad del disparo
     * @param rotacion Rotacion del disparo
     * @param fuerzaDeDisparo Fuerza del disparo
     * @param texturaDir Direccion de la textura
     * @param controlador Controlador del disparo
     * @return Nuevo disparo
     */
    T crearDisparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador);
}