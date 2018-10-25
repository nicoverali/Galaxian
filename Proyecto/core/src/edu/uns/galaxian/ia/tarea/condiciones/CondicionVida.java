package edu.uns.galaxian.ia.tarea.condiciones;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.tarea.Tarea;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.Comparador;
import edu.uns.galaxian.util.enums.Comparacion;

public class CondicionVida<T extends EntidadViva & Autonomo> implements Tarea<T> {

    private Blackboard<T> bboard;
    private Comparacion comparacion;
    private int vidaObjetivo;
    private boolean seCumpleCondicion;

    public CondicionVida(Blackboard<T> blackboard, final int vidaObjetivo, final Comparacion comparacion){
        this.bboard = blackboard;
        this.vidaObjetivo = vidaObjetivo;
        this.comparacion = comparacion;
        final T autonomoVivo = bboard.getAutonomo();
        seCumpleCondicion = Comparador.compararNumero(autonomoVivo.getVida().getValor(), vidaObjetivo, comparacion);

        blackboard.getAutonomo().getVida().observar(new Observador<LiveData<Integer>>() {
            public void notificar(LiveData<Integer> subject) {
                seCumpleCondicion = Comparador.compararNumero(autonomoVivo.getVida().getValor(), vidaObjetivo, comparacion);
            }
        });
    }

    public boolean realizar(float delta) {
        return seCumpleCondicion;
    }
}
