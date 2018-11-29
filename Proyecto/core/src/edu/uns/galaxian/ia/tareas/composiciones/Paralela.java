package edu.uns.galaxian.ia.tareas.composiciones;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

import java.util.List;

public class Paralela<T extends Autonomo> extends TareaComposicion<T> {

    public Paralela(Blackboard<T> blackboard, List<Tarea> tareas) {
        super(blackboard, tareas);
    }

    public Paralela(List<Tarea> tareas) {
        super(tareas);
    }

    public Paralela(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public Paralela() {
        super();
    }

    public boolean realizar(float delta) {
        boolean resultado = true;
        for(Tarea tarea : tareas){
            resultado = resultado && tarea.realizar(delta);
        }
        return resultado;
    }
}