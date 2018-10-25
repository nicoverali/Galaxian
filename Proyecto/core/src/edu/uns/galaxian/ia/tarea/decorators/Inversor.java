package edu.uns.galaxian.ia.tarea.decorators;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

public class Inversor<T extends Autonomo> extends TareaDecorator<T> {

    public Inversor(Tarea tareaDecorada){
        super(tareaDecorada);
    }

    public boolean realizar(float delta) {
        return !tareaDecorada.realizar(delta);
    }
}
