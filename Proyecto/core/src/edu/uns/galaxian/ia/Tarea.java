package edu.uns.galaxian.ia;

public abstract class Tarea<T extends Autonomo> {

    protected Blackboard<T> blackboard;

    public Tarea(Blackboard<T> blackboard){
        this.blackboard = blackboard;
    }

    public Tarea(){
        blackboard = null;
    }

    /**
     * Cambia el Blackboard de la tarea por uno nuevo
     * @param blackboard Nuevo blackboard
     */
    public void setBlackboard(Blackboard<T> blackboard){
        this.blackboard = blackboard;
    }

    /**
     * Realiza la tarea retornando verdadero si finalizo satisfactoriamente,
     * o falso en caso contrario.
     * @param delta DeltaTime
     * @return Estado final de la tarea
     */
    public abstract boolean realizar(float delta);





}
