package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public abstract class SteeringVelocidad<T extends AutonomoDinamico> extends Tarea<T> {

    public SteeringVelocidad(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public SteeringVelocidad() {
    }

    public boolean realizar(float delta) {
        if(!blackboard.hayObjetivo()){
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        Vector2 steeringVector = getSteeringVector();
        autonomo.setVelocidad(autonomo.getVelocidad().add(steeringVector).limit(autonomo.getVelocidadMaxima()));
        autonomo.setPosicion(autonomo.getPosicion().add(autonomo.getVelocidad().scl(delta)));
        return true;
    }

    abstract protected Vector2 getSteeringVector();

}
