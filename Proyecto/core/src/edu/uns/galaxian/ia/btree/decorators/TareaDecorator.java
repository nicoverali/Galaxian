package edu.uns.galaxian.ia.btree.decorators;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;

public abstract class TareaDecorator<T extends Autonomo> implements Tarea<T>{

    protected Tarea tareaDecorada;

    public TareaDecorator(Tarea tareaDecorada){
        this.tareaDecorada = tareaDecorada;
    }
}
