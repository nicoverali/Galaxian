package edu.uns.galaxian.entidades.jugador.nave;

import com.badlogic.gdx.graphics.Texture;

public interface NaveJugador {

    /**
     * Retorna la vida maxima de la nave.
     * @return Vida maxima de la nave
     */
    int getVidaMax();

    /**
     * Retorna la velocidad maxima de la nave.
     * @return Velocidad maxima de la nave
     */
    int getVelocidad();

    /**
     * Retorna la textura asociada a la nave.
     * @return Textura asociada a la nave
     */
    Texture getTextura();

    /**
     * Retorna el ancho de la nave
     * @return Ancho de la nave
     */
    int getAncho();

    /**
     * Retorna el alto de la nave.
     * @return Alto de la nave
     */
    int getAlto();

}