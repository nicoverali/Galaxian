package edu.uns.galaxian.ia.inteligencias.transicion;

import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;

public class TransicionTarea<T extends Autonomo> implements InteligenciaArtificial<T> {

    private T autonomo;
    private InteligenciaArtificial<T> inteligenciaSiguiente;
    private Tarea<T> tarea;

    public TransicionTarea(T autonomo, Tarea<T> tarea, InteligenciaArtificial<T> intelgenciaSiguiente){
        this.autonomo = autonomo;
        this.tarea = tarea;
        this.inteligenciaSiguiente = intelgenciaSiguiente;
    }

    public void pensar(float delta) {
        if(!tarea.realizar(delta)){
            autonomo.setInteligencia(inteligenciaSiguiente);
        }
    }

    public void transicionar(InteligenciaArtificial<T> nuevaInteligencia) {
        autonomo.setInteligencia(nuevaInteligencia);
    }
}
