package edu.uns.galaxian.ia.tareas.composiciones;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

import java.util.List;

public class Selector<T extends Autonomo> extends TareaComposicion<T> {

    public Selector(Blackboard<T> blackboard, List<Tarea> tareas) {
        super(blackboard, tareas);
    }

    public Selector(List<Tarea> tareas) {
        super(tareas);
    }

    public Selector(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public Selector() {
        super();
    }

    public boolean realizar(float delta){
        for(Tarea tarea : tareas){
            if(tarea.realizar(delta) == true){
                return true;
            }
        }
        return false;
    }

}
