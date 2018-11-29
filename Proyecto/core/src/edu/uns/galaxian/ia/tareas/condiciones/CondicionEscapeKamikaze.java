package edu.uns.galaxian.ia.tareas.condiciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class CondicionEscapeKamikaze<T extends Enemigo> extends Tarea<T> {

    private static final int CERCANIA_HORI_CONSIDERABLE = 70;
    private static final int CERCANIA_HORI_OBLIGATORIA = 20;
    private static final int CERCANIA_VERT_CONSIDERABLE = 50;
    private static final int CERCANIA_VERT_OBLIGATORIA = 10;

    public CondicionEscapeKamikaze(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public CondicionEscapeKamikaze() {
    }

    public boolean realizar(float delta) {
        if(!blackboard.hayObjetivo()){
            return false;
        }
        Vector2 posicionEnemigo = blackboard.getAutonomo().getPosicion();
        Vector2 posicionObjetivo = blackboard.getObjetivo().getPosicion();
        float distanciaVertical = posicionEnemigo.y - posicionObjetivo.y;
        float distanciaHorizontal = Math.abs(posicionEnemigo.x - posicionObjetivo.x);
        if(distanciaVertical < CERCANIA_VERT_CONSIDERABLE){
            if(distanciaHorizontal > CERCANIA_HORI_CONSIDERABLE){
                return true;
            }
            if(distanciaVertical < CERCANIA_VERT_OBLIGATORIA){
                return distanciaHorizontal > CERCANIA_HORI_OBLIGATORIA;
            }
        }
        return false;
    }
}