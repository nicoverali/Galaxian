package edu.uns.galaxian.entidades.autonoma;

import com.badlogic.gdx.math.Vector2;

public interface AutonomoDinamico extends Autonomo {

    /**
     * Retorna la velocidad maxima del autonomo
     * @return Velocidad maxima
     */
    float getVelocidadMaxima();

    /**
     * Retorna el steering maximo
     * @return Steering maximo
     */
    float getSteeringMaximo();

    /**
     * Modifica la velocidad actual del autonomo
     * @param velocidad Nueva velocidad del autonomo
     */
    void setVelocidad(Vector2 velocidad);

    /**
     * Modifica la posicion actual del autonomo
     * @param posicion Nueva posicion del autonomo
     */
    void setPosicion(Vector2 posicion);

    /**
     * Modifica la rotacion actual del autonomo
     * @param rotacion Nueva rotacion del autonomo
     */
    void setRotacion(float rotacion);

}
