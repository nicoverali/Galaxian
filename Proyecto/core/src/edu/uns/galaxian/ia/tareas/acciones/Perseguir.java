package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.juego.GameObject;

public class Perseguir<T extends AutonomoDinamico> extends SteeringVelocidad<T> {

    public Perseguir(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public Perseguir() {
    }

    protected Vector2 getSteeringVector() {
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        GameObject objetivo = blackboard.getObjetivo();
        return blackboard.getSteeringManager().perseguir(autonomo, objetivo);
    }
}
