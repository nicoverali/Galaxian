package edu.uns.galaxian.ia.btree.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.autonomo.AutonomoDinamico;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class Perseguir<T extends AutonomoDinamico> implements Tarea<T> {

    private Blackboard<T> blackboard;
    private SteeringManager steering;

    public Perseguir(Blackboard<T> blackboard){
        this.blackboard = blackboard;
        steering = new SteeringManager();
    }

    public boolean realizar(float delta) {
        if(blackboard.getObjetivo() == null){
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        SteeringManager steering = blackboard.getSteeringManager();
        Vector2 steeringVector = steering.perseguir(autonomo, blackboard.getObjetivo());
        autonomo.setVelocidad(autonomo.getVelocidad().add(steeringVector).limit(autonomo.getVelocidadMaxima()));
        autonomo.setPosicion(autonomo.getPosicion().add(autonomo.getVelocidad().scl(delta)));
        return true;
    }

}
