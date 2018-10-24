package edu.uns.galaxian.ia.tarea.composiciones;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

import java.util.List;

public class Selector<T extends Autonomo> extends TareaComposicion<T> {

    public Selector(List<Tarea> tareas){
        super(tareas);
    }

    public Selector(){
        super();
    }

    public boolean realizar(){
        for(Tarea tarea : tareas){
            if(tarea.realizar() == true){
                return true;
            }
        }
        return false;
    }

}
