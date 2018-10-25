package edu.uns.galaxian.ia.btree.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.autonomo.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class Seek<T extends AutonomoDinamico> implements Tarea<T> {

    private Blackboard<T> blackboard;
    private Vector2 posicionObjetivo;
    private SteeringManager steering;

    public Seek(Blackboard<T> blackboard, Vector2 posicionObjetivo){
        this.blackboard = blackboard;
        this.posicionObjetivo = posicionObjetivo;
        steering = blackboard.getSteeringManager();
    }

    public Seek(Blackboard<T> blackboard){
        this(blackboard, null);
    }

    public boolean realizar(float delta) {
        Vector2 objetivo;
        if(posicionObjetivo != null){
            objetivo = posicionObjetivo;
        }
        else if(blackboard.getObjetivo() != null){
            objetivo = blackboard.getObjetivo().getPosicion();
        }
        else{
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        Vector2 steeringVector = steering.seek(autonomo, objetivo);
        autonomo.setVelocidad(autonomo.getVelocidad().add(steeringVector).limit(autonomo.getVelocidadMaxima()));
        autonomo.setPosicion(autonomo.getPosicion().add(autonomo.getVelocidad().scl(delta)));
        return true;
    }
}
