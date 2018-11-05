package edu.uns.galaxian.ia.btree;

import edu.uns.galaxian.ia.autonomo.Autonomo;

public interface Tarea<T extends Autonomo> {

    /**
     * Realiza la tarea retornando verdadero si finalizo satisfactoriamente,
     * o falso en caso contrario.
     * @param delta DeltaTime
     * @return Estado final de la tarea
     */
    boolean realizar(float delta);

}