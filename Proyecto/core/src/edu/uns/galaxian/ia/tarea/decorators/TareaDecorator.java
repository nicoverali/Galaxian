package edu.uns.galaxian.ia.tarea.decorators;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

public abstract class TareaDecorator<T extends Autonomo> implements Tarea<T>{

    protected Tarea tareaDecorada;

    public TareaDecorator(Tarea tareaDecorada){
        this.tareaDecorada = tareaDecorada;
    }
}
