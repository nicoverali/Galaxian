package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;

public class SeekPosicion<T extends AutonomoDinamico> extends SteeringVelocidadPosicion<T> {

    public SeekPosicion(Blackboard<T> blackboard, Vector2 posicionObjetivo) {
        super(blackboard, posicionObjetivo);
    }

    public SeekPosicion(Vector2 posicionObjetivo) {
        super(posicionObjetivo);
    }

    protected Vector2 getSteeringVector() {
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        return blackboard.getSteeringManager().seek(autonomo, posicionObjetivo);
    }
}
