package edu.uns.galaxian.ia.tarea;

import edu.uns.galaxian.entidades.autonoma.Autonomo;

public interface Tarea<T extends Autonomo> {

    /**
     * Realiza la tarea retornando verdadero si finalizo satisfactoriamente,
     * o falso en caso contrario.
     * @return Estado final de la tarea
     */
    boolean realizar();

}
