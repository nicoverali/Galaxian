package edu.uns.galaxian.oleada;

public interface Oleada {

    /**
     * Inicia la oleada
     * @throws IllegalStateException Si la oleada ya fue iniciada
     */
    void iniciar() throws IllegalStateException;

    /**
     * Actualiza el estado de la oleada
     * @param delta Delta Time
     * @throws IllegalStateException Si la oleada no fue iniciada
     */
    void actualizar(float delta) throws IllegalStateException;

    /**
     * Finaliza la oleada
     * @throws IllegalStateException Si la oleada no fue iniciada
     */
    void finalizar() throws IllegalStateException;

}
