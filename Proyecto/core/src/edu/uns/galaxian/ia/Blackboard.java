package edu.uns.galaxian.ia;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.status.GameObject;

import java.util.HashMap;
import java.util.Map;

public class Blackboard<T extends Autonomo> {

    private T autonomo;
    private GameObject objetivo;
    private Map<String, Object> blackboard;

    public Blackboard(T autonomo, GameObject objetivo){
        this.autonomo = autonomo;
        this.objetivo = objetivo;
        blackboard = new HashMap<>();
    }

    public Blackboard(T autonomo){
        this.autonomo = autonomo;
    }

    /**
     * Retorna el autonomo al cual representa ese blackboard
     * @return Autonomo representado por blackboard
     */
    public T getAutonomo(){
        return autonomo;
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
     * Inserta un valor en el blackboard con la key proveida
     * @param key Key de la entrada
     * @param valor Valor de la entrada
     */
    public void putInBlackboard(String key, Object valor){
        blackboard.put(key, valor);
    }

    public Object getFromBlackboard(String key){
        return blackboard.get(key);
    }
}
