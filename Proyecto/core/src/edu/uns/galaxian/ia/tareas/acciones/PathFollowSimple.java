package edu.uns.galaxian.ia.tareas.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;
import edu.uns.galaxian.util.camino.CaminoSimple;

public class PathFollowSimple<T extends AutonomoDinamico> extends Tarea<T> {

    private static final int RADIO_LLEGADA = 20;

    private Blackboard<T> blackboard;
    private CaminoSimple camino;
    private int cantVueltas;
    private int cantVueltasActuales;
    private SteeringManager steeringManager;

    public PathFollowSimple(Blackboard<T> blackboard, CaminoSimple camino, int cantVueltas){
        this.blackboard = blackboard;
        this.camino = camino;
        this.cantVueltas = cantVueltas;
        cantVueltasActuales = 0;
        steeringManager = blackboard.getSteeringManager();
    }

    public boolean realizar(float delta) {
        if(camino.caminoFinalizado()){
            if(++cantVueltasActuales >= cantVueltas){
                return false;
            }
            camino.reinciarCamino();
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        Vector2 paradaActual = camino.getParadaActual();
        float distancia = autonomo.getPosicion().dst(paradaActual);
        if(distancia < RADIO_LLEGADA){
            paradaActual = camino.avanzar();
        }
        Vector2 steering = steeringManager.arrive(autonomo, paradaActual, RADIO_LLEGADA);
        autonomo.setVelocidad(autonomo.getVelocidad().add(steering).limit(autonomo.getVelocidadMaxima()));
        autonomo.setPosicion(autonomo.getPosicion().add(autonomo.getVelocidad().scl(delta)));
        return true;
    }
}