package edu.uns.galaxian.servicios;

public interface Servicio {

    /**
     * Activa la funcionalidad del servicio
     * @throws IllegalStateException Si el servicio ya esta activo
     */
    void activar() throws IllegalStateException;

    /**
     * Desactiva la funcionalidad del serivicio
     * @throws IllegalStateException Si el servicio no esta activo
     */
    void desactivar() throws IllegalStateException;

}
