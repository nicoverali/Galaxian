package edu.uns.galaxian.animacion;

public interface EstadoAnimacion {
    /**
     * Realiza la accion del estado
     * @param delta Delta Time
     */
    void accion(float delta);
}