package edu.uns.galaxian.ia.tarea.composiciones;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

import java.util.List;

public class Selector<T extends Autonomo> extends TareaComposicion<T> {

    public Selector(List<Tarea> tareas){
        super(tareas);
    }

    public Selector(){
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
