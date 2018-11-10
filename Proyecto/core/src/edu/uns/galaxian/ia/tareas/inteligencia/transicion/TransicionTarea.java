package edu.uns.galaxian.ia.tareas.inteligencia.transicion;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class TransicionTarea<T extends Autonomo> extends Tarea<T> {

    private Tarea<T> inteligenciaSiguiente;
    private Tarea<T> tarea;

    public TransicionTarea(Blackboard<T> blackboard, Tarea<T> inteligenciaSiguiente, Tarea<T> tarea) {
        super(blackboard);
        this.inteligenciaSiguiente = inteligenciaSiguiente;
        this.tarea = tarea;
    }

    public TransicionTarea(Tarea<T> inteligenciaSiguiente, Tarea<T> tarea) {
        this.inteligenciaSiguiente = inteligenciaSiguiente;
        this.tarea = tarea;
    }

    public boolean realizar(float delta) {
        T autonomo = blackboard.getAutonomo();
        if(!tarea.realizar(delta)){
            autonomo.setTareaInteligencia(inteligenciaSiguiente);
            return false;
        }
        return true;
    }
}
