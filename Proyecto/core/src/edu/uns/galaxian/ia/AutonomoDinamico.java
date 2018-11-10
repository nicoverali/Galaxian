package edu.uns.galaxian.ia;

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
}
