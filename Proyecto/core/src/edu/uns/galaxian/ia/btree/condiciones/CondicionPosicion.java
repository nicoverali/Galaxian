package edu.uns.galaxian.ia.btree.condiciones;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.util.Comparador;
import edu.uns.galaxian.util.enums.Comparacion;
import edu.uns.galaxian.util.enums.Componente;

public class CondicionPosicion<T extends Autonomo> implements Tarea<T> {

    private Blackboard<T> blackboard;
    private Componente componente;
    private float objetivo;
    private Comparacion comparacion;

    public CondicionPosicion(Blackboard<T> blackboard, Componente referencia, Comparacion comparacion, float objetivo){
        this.blackboard = blackboard;
        this.componente = referencia;
        this.objetivo = objetivo;
        this.comparacion = comparacion;
    }

    public boolean realizar(float delta) {
        T autonomo = blackboard.getAutonomo();
        float componenteRef = getComponente(autonomo.getPosicion(), componente);
        boolean desarolloOnly = Comparador.compararNumero(componenteRef, objetivo, comparacion);
        return desarolloOnly;
    }

    private float getComponente(Vector2 vector, Componente componente){
        switch (componente){
            case X: return vector.x;
            case Y: return vector.y;
            default: return 0;
        }
    }
}
