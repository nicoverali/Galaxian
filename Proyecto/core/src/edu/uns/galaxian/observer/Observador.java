package edu.uns.galaxian.observer;

public interface Observador<T> {

    /**
     * Notifica al observador que el subject recibido sufrio
     * un cambio.
     * @param subject Subject observado que cambio su estado
     */
    void notificar(T subject);

}
