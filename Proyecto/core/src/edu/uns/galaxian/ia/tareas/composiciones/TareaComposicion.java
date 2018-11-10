package edu.uns.galaxian.ia.tareas.composiciones;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaComposicion<T extends Autonomo> extends Tarea<T> {

    protected List<Tarea> tareas;

    public TareaComposicion(Blackboard<T> blackboard, List<Tarea> tareas){
        super(blackboard);
        this.tareas = tareas;
    }

    public TareaComposicion(List<Tarea> tareas){
        super();
        this.tareas = tareas;
    }

    public TareaComposicion(Blackboard<T> blackboard){
        super(blackboard);
        this.tareas = new ArrayList<>();
    }

    public TareaComposicion(){
        this.tareas = new ArrayList<>();
    }

    /**
     * Agrega una nueva tarea como ultima a realizar
     * @param tarea Nueva tarea
     */
    public void addUltimaTarea(Tarea tarea){
        tareas.add(tareas.size(), tarea);
    }

    /**
     * Agrega una primer tarea
     * @param tarea Nueva tarea
     */
    public void addPrimeraTarea(Tarea tarea){
        tareas.add(tarea);
    }

    /**
     * Retorna la cantidad de tareas de esta composicion.
     * @return Cantidad de tareas de la composicion
     */
    public int getCantidadTareas(){
        return tareas.size();
    }
}
