package edu.uns.galaxian.ia.tareas.decorators;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public abstract class TareaDecorator<T extends Autonomo> extends Tarea<T>{

    protected Tarea tareaDecorada;

    public TareaDecorator(Blackboard<T> blackboard, Tarea tareaDecorada){
        super(blackboard);
        this.tareaDecorada = tareaDecorada;
    }

    public TareaDecorator(Tarea tareaDecorada){
        super();
        this.tareaDecorada = tareaDecorada;
    }
}