package edu.uns.galaxian.ia.tareas.decorators;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class Inversor<T extends Autonomo> extends TareaDecorator<T> {

    public Inversor(Blackboard<T> blackboard, Tarea tareaDecorada){
        super(blackboard, tareaDecorada);
    }

    public Inversor(Tarea tareaDecorada){
        super(tareaDecorada);
    }

    public boolean realizar(float delta) {
        return !tareaDecorada.realizar(delta);
    }
}