package edu.uns.galaxian.ia.btree.acciones;

import edu.uns.galaxian.ia.autonomo.AutonomoDinamico;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class MirarA<T extends AutonomoDinamico> implements Tarea<T> {

    private static final float FACTOR_ROTACION = 1.3f;

    private Blackboard<T> blackboard;
    private SteeringManager steeringManager;

    public MirarA(Blackboard<T> blackboard){
        this.blackboard = blackboard;
        steeringManager = blackboard.getSteeringManager();
    }

    public boolean realizar(float delta) {
        if(blackboard.getObjetivo() == null){
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        GameObject objetivo = blackboard.getObjetivo();
        float steeringAngular = steeringManager.mirarA(autonomo, objetivo);
        autonomo.setRotacion(autonomo.getRotacion() + steeringAngular * delta);
        return true;
    }
}
