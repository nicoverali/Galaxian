package edu.uns.galaxian.ia.tareas.decorators;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class HastaFallar<T extends Autonomo> extends TareaDecorator<T> {

    public HastaFallar(Blackboard<T> blackboard, Tarea tareaDecorada){
        super(blackboard, tareaDecorada);
    }

    public HastaFallar(Tarea tareaDecorada){
        super(tareaDecorada);
    }

    public boolean realizar(float delta) {
        while(!tareaDecorada.realizar(delta)){
            // Seguir realizandola en la expresion del while
        }
        return false;
    }
}
