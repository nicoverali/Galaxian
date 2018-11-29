package edu.uns.galaxian.ia;

import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class Blackboard<T extends Autonomo> {

    private T autonomo;
    private GameObject objetivo;
    private SteeringManager steeringManager;

    public Blackboard(T autonomo, GameObject objetivo){
        this.autonomo = autonomo;
        this.objetivo = objetivo;
        steeringManager = new SteeringManager();
    }

    public Blackboard(T autonomo){
        this.autonomo = autonomo;
        steeringManager = new SteeringManager();
    }

    /**
     * Retorna el autonomo al cual representa ese blackboard
     * @return Autonomo representado por blackboard
     */
    public T getAutonomo(){
        return autonomo;
    }

    /**
     * Verifica si hay un objetivo registrado en el
     * blackboard
     * @return Verdadero si hay un objetivo registrado
     */
    public boolean hayObjetivo(){
        return this.objetivo != null;
    }

    /**
     * Retorna el objetivo del autonomo. Es posible que el
     * objetivo sea nulo.
     * @return Objetivo del autonomo representado por el blackboard
     */
    public GameObject getObjetivo() {
        return objetivo;
    }

    /**
     * Retorna el SteeringManager asociado a este Blackboard
     * @return SteeringManager
     */
    public SteeringManager getSteeringManager() {
        return steeringManager;
    }
}