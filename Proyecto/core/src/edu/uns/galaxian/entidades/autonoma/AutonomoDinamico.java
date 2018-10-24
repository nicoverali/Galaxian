package edu.uns.galaxian.entidades.autonoma;

import com.badlogic.gdx.math.Vector2;

public interface AutonomoDinamico extends Autonomo {

    /**
     * Retorna la velocidad maxima del autonomo
     * @return Velocidad maxima
     */
    float getVelocidadMaxima();

    /**
     * Retorna el utils maximo
     * @return Steering maximo
     */
    float getSteeringMaximo();
}
