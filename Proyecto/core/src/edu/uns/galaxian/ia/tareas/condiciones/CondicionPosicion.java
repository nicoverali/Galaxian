package edu.uns.galaxian.ia.tareas.condiciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.util.Comparador;
import edu.uns.galaxian.util.enums.Comparacion;
import edu.uns.galaxian.util.enums.Componente;

public class CondicionPosicion<T extends Autonomo> extends Tarea<T> {

    private Comparacion comparacion;
    private Componente componente;
    private float objetivo;

    public CondicionPosicion(Blackboard<T> blackboard, Componente referencia, Comparacion comparacion, float objetivo){
        super(blackboard);
        this.componente = referencia;
        this.objetivo = objetivo;
        this.comparacion = comparacion;
    }

    public CondicionPosicion(Componente referencia, Comparacion comparacion, float objetivo){
        super();
        this.componente = referencia;
        this.objetivo = objetivo;
        this.comparacion = comparacion;
    }

    public boolean realizar(float delta) {
        T autonomo = blackboard.getAutonomo();
        float componenteRef = getComponente(autonomo.getPosicion(), componente);
        return Comparador.compararNumero(componenteRef, objetivo, comparacion);
    }

    private float getComponente(Vector2 vector, Componente componente){
        switch (componente){
            case X: return vector.x;
            case Y: return vector.y;
            default: return 0;
        }
    }
}