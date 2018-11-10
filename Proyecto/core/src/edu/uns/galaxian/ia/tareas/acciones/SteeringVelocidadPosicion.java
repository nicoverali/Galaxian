package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public abstract class SteeringVelocidadPosicion<T extends AutonomoDinamico> extends Tarea<T> {

    protected Vector2 posicionObjetivo;

    public SteeringVelocidadPosicion(Blackboard<T> blackboard, Vector2 posicionObjetivo) {
        super(blackboard);
        this.posicionObjetivo = posicionObjetivo;
    }

    public SteeringVelocidadPosicion(Vector2 posicionObjetivo) {
        this.posicionObjetivo = posicionObjetivo;
    }

    public boolean realizar(float delta) {
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        Vector2 steeringVector = getSteeringVector();
        autonomo.setVelocidad(autonomo.getVelocidad().add(steeringVector).limit(autonomo.getVelocidadMaxima()));
        autonomo.setPosicion(autonomo.getPosicion().add(autonomo.getVelocidad().scl(delta)));
        return true;
    }

    abstract protected Vector2 getSteeringVector();
}
