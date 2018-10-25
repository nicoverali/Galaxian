package edu.uns.galaxian.ia.tarea.composiciones;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.tarea.Tarea;

import java.util.List;

public class Paralela<T extends Autonomo> extends TareaComposicion<T> {

    public Paralela(List<Tarea> tareas){
        super(tareas);
    }

    public Paralela(){
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
