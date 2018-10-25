package edu.uns.galaxian.ia.tarea.composiciones;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

import java.util.List;

public class Secuencia<T extends Autonomo> extends TareaComposicion<T> {

    public Secuencia(List<Tarea> tareas){
        super(tareas);
    }

    public Secuencia(){
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
