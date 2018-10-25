package edu.uns.galaxian.ia.btree.composiciones;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaComposicion<T extends Autonomo> implements Tarea {

    protected List<Tarea> tareas;

    public TareaComposicion(List<Tarea> tareas){
        this.tareas = tareas;
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
