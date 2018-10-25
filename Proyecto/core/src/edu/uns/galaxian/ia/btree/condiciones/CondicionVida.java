package edu.uns.galaxian.ia.btree.condiciones;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.Comparador;
import edu.uns.galaxian.util.enums.Comparacion;

public class CondicionVida<T extends EntidadViva & Autonomo> implements Tarea<T> {

    private Blackboard<T> bboard;
    private Comparacion comparacion;
    private int vidaObjetivo;

    public CondicionVida(Blackboard<T> blackboard, final int vidaObjetivo, final Comparacion comparacion){
        this.bboard = blackboard;
        this.vidaObjetivo = vidaObjetivo;
        this.comparacion = comparacion;
    }

    public boolean realizar(float delta) {
        return Comparador.compararNumero(bboard.getAutonomo().getVida().getValor(), vidaObjetivo, comparacion);
    }
}
