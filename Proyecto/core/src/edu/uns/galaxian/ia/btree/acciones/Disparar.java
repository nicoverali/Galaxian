package edu.uns.galaxian.ia.btree.acciones;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.juego.GameObject;

public class Disparar<T extends EntidadConNave & Autonomo> implements Tarea<T> {

    private Blackboard<T> blackboard;
    private float precision;

    public Disparar(Blackboard<T> blackboard, float precision){
        this.blackboard = blackboard;
        this.precision = precision;
    }

    public boolean realizar(float delta) {
        T entidad = blackboard.getAutonomo();
        GameObject objetivo = blackboard.getObjetivo();
        if(objetivo == null){
            return false;
        }
        float rotacionNecesaria = objetivo.getPosicion().sub(entidad.getPosicion()).angle();
        if(Math.abs(rotacionNecesaria - entidad.getRotacion()) < precision){
            entidad.disparar();
        }
        return true;
    }
}
