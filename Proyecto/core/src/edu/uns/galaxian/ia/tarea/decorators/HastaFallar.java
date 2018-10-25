package edu.uns.galaxian.ia.tarea.decorators;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

public class HastaFallar<T extends Autonomo> extends TareaDecorator<T> {

    public HastaFallar(Tarea tareaDecorada){
        super(tareaDecorada);
    }

    public boolean realizar(float delta) {
        while(tareaDecorada.realizar(delta) == false){
            // Seguir realizandola
        }
        return false;
    }
}
