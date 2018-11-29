package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class MirarA<T extends AutonomoDinamico> extends Tarea<T> {

    public MirarA(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public MirarA() {
    }

    public boolean realizar(float delta) {
        if(!blackboard.hayObjetivo()){
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        Vector2 posicionAutonomo = autonomo.getPosicion();
        Vector2 posicionObjetivo = blackboard.getObjetivo().getPosicion();
        Vector2 direccion = posicionObjetivo.sub(posicionAutonomo);
        float steeringAngular = blackboard.getSteeringManager().alinear(autonomo, direccion.angle());
        autonomo.setRotacion(autonomo.getRotacion() + steeringAngular);
        return true;
    }
}