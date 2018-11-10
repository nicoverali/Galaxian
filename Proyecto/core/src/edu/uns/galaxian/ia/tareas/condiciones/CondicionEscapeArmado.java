package edu.uns.galaxian.ia.tareas.condiciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;

public class CondicionEscapeArmado<T extends Enemigo> extends Tarea<T> {

    private static final int RADIO_CERCANIA = 150;
    private static final int CERCANIA_VERT = 50;

    public CondicionEscapeArmado(Blackboard<T> blackboard) {
        super(blackboard);
    }

    public CondicionEscapeArmado() {
    }

    public boolean realizar(float delta) {
        if(!blackboard.hayObjetivo()){
            return false;
        }
        Vector2 posicionEnemigo = blackboard.getAutonomo().getPosicion();
        Vector2 posicionObjetivo = blackboard.getObjetivo().getPosicion();
        float distanciaVertical = posicionEnemigo.y - posicionObjetivo.y;
        float distancia = posicionObjetivo.dst(posicionEnemigo);
        return distancia < RADIO_CERCANIA || distanciaVertical < CERCANIA_VERT;
    }

}
