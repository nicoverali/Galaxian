package edu.uns.galaxian.ia.tarea.acciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.tarea.Tarea;

public class MirarA<T extends AutonomoDinamico> implements Tarea<T> {

    private static final float FACTOR_ROTACION = 1.3f;

    private Blackboard<T> blackboard;
    private float velocidadDeRotacionActual;
    private float velocidadDeRotacionAnterior;

    public MirarA(Blackboard<T> blackboard){
        this.blackboard = blackboard;
        this.velocidadDeRotacionActual = 0;
        this.velocidadDeRotacionAnterior = 0;
    }

    public boolean realizar() {
        if(blackboard.getObjetivo() == null){
            return false;
        }
        AutonomoDinamico autonomo = blackboard.getAutonomo();
        GameObject objetivo = blackboard.getObjetivo();
        Vector2 vectorActual = Vector2.X.cpy().rotate(autonomo.getRotacion());
        Vector2 vectorDeseado = objetivo.getPosicion().sub(autonomo.getPosicion());
        float rotacionDeseada = vectorActual.nor().angle(vectorDeseado.nor());
        float rotacionFinal = (rotacionDeseada*FACTOR_ROTACION) / autonomo.getSteeringMaximo();
        float aceleracion = rotacionFinal - velocidadDeRotacionAnterior;
        float temp = velocidadDeRotacionActual;
        velocidadDeRotacionActual = velocidadDeRotacionAnterior + aceleracion;
        velocidadDeRotacionAnterior = temp;
        autonomo.setRotacion(velocidadDeRotacionActual + autonomo.getRotacion());
        return true;
    }
}
