package edu.uns.galaxian.ia.tareas.acciones;

import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class AlinearRotacion<T extends AutonomoDinamico> extends Tarea<T> {

    private float rotacionObjetivo;

    public AlinearRotacion(Blackboard<T> blackboard, float rotacionObjetivo) {
        super(blackboard);
        this.rotacionObjetivo = rotacionObjetivo;
    }

    public AlinearRotacion(float rotacionObjetivo) {
        this.rotacionObjetivo = rotacionObjetivo;
    }

    public boolean realizar(float delta) {
        SteeringManager steeringManager = blackboard.getSteeringManager();
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        float steeringAngular = steeringManager.alinear(autonomo, rotacionObjetivo);
        autonomo.setRotacion(autonomo.getRotacion() + steeringAngular);
        return true;
    }
}