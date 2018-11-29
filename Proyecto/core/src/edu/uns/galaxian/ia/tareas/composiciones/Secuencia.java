package edu.uns.galaxian.ia.tareas.composiciones;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

import java.util.List;

public class Secuencia<T extends Autonomo> extends TareaComposicion<T> {

    public Secuencia(Blackboard<T> blackboard, List<Tarea> tareas) {
        super(blackboard, tareas);
    }

    public Secuencia(List<Tarea> tareas) {
        super(tareas);
    }

    public Secuencia(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public Secuencia() {
        super();
    }

    public boolean realizar(float delta) {
        for(Tarea tarea : tareas){
            if(tarea.realizar(delta) == false){
                return false;
            }
        }
        return true;
    }
}