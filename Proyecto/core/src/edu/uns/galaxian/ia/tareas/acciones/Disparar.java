package edu.uns.galaxian.ia.tareas.acciones;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.juego.GameObject;

public class Disparar<T extends EntidadConNave & Autonomo> extends Tarea<T> {

    private float precision;

    public Disparar(Blackboard<T> blackboard, float precision) {
        super(blackboard);
        this.precision = precision;
    }

    public Disparar(float precision) {
        this.precision = precision;
    }

    public boolean realizar(float delta) {
        if(!blackboard.hayObjetivo()){
            return false;
        }
        T entidad = blackboard.getAutonomo();
        GameObject objetivo = blackboard.getObjetivo();
        float rotacionNecesaria = objetivo.getPosicion().sub(entidad.getPosicion()).angle();
        if(Math.abs(rotacionNecesaria - entidad.getRotacion()) < precision){
            entidad.disparar();
        }
        return true;
    }
}
