package edu.uns.galaxian.ia.tareas.condiciones;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.ia.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.util.Comparador;
import edu.uns.galaxian.util.enums.Comparacion;

public class CondicionVida<T extends EntidadViva & Autonomo> extends Tarea<T> {

    private Comparacion comparacion;
    private int vidaObjetivo;

    public CondicionVida(Blackboard<T> blackboard, int vidaObjetivo, Comparacion comparacion){
        super(blackboard);
        this.vidaObjetivo = vidaObjetivo;
        this.comparacion = comparacion;
    }

    public CondicionVida(int vidaObjetivo, Comparacion comparacion){
        super();
        this.vidaObjetivo = vidaObjetivo;
        this.comparacion = comparacion;
    }

    public boolean realizar(float delta) {
        return Comparador.compararNumero(blackboard.getAutonomo().getVida().getValor(), vidaObjetivo, comparacion);
    }
}
