package edu.uns.galaxian.ia.btree.decorators;

import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;

public class HastaCondicion<T extends Autonomo> extends TareaDecorator<T> {

    private Tarea<T> tareaCondicion;
    private boolean objetivoCondicion;
    private boolean estado;

    public HastaCondicion(Tarea<T> tareaDecorada, Tarea<T> condicion, boolean objetivoCondicion){
        super(tareaDecorada);
        this.tareaCondicion = condicion;
        this.objetivoCondicion = objetivoCondicion;
        estado = true;
    }

    public boolean realizar(float delta) {
        if(tareaCondicion.realizar(delta) == objetivoCondicion){
            estado = false;
        }
        if(estado){
            return tareaDecorada.realizar(delta);
        }
        return false;
    }
}
