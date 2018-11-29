package edu.uns.galaxian.animacion.animator;

public interface CicloAnimator {

    /**
     * Inicia el ciclo con la duracion dada.
     * @param duracion Duracion del ciclo
     */
    void iniciarCiclo(long duracion);

    /**
     * Verifica si el ciclo finalizo. Dependiendo
     * del tipo de ciclo, puede no finalizar nunca
     * @return Verdadero si el ciclo finalizo, falso en caso contrario
     */
    boolean cicloFinalizado();

    /**
     * Retorna un valor entre 0 y 1 representando
     * el tiempo actual, de acuerdo al tiempo inicial
     * del ciclo y la duracion del mismo
     * @return Valor entre 0 y 1
     */
    double getTiempoActual();

}