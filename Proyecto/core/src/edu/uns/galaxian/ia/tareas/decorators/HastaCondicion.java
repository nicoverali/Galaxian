package edu.uns.galaxian.ia.tareas.decorators;

import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class HastaCondicion<T extends Autonomo> extends TareaDecorator<T> {

    private Tarea tareaCondicion;
    private boolean resultadoDeCambio;
    private boolean estado;

    public HastaCondicion(Blackboard<T> blackboard, Tarea tareaDecorada, Tarea condicion, boolean resultadoDeCambio){
        super(blackboard, tareaDecorada);
        this.tareaCondicion = condicion;
        this.resultadoDeCambio = resultadoDeCambio;
        estado = true;
    }

    public HastaCondicion(Tarea tareaDecorada, Tarea condicion, boolean resultadoDeCambio){
        super(tareaDecorada);
        this.tareaCondicion = condicion;
        this.resultadoDeCambio = resultadoDeCambio;
        estado = true;
    }

    public boolean realizar(float delta) {
        if(tareaCondicion.realizar(delta) == resultadoDeCambio){
            estado = false;
        }
        if(estado){
            return tareaDecorada.realizar(delta);
        }
        return false;
    }
}