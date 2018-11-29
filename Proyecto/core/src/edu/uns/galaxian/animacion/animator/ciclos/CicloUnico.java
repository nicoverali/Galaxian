package edu.uns.galaxian.animacion.animator.ciclos;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.animacion.animator.CicloAnimator;

public class CicloUnico implements CicloAnimator {

    private long tiempoInicial;
    private long duracion;

    public void iniciarCiclo(long duracion) {
        this.duracion = duracion;
        tiempoInicial = TimeUtils.millis();
    }

    public boolean cicloFinalizado() {
        return TimeUtils.timeSinceMillis(tiempoInicial) >= duracion;
    }

    public double getTiempoActual() {
        double tiempoActual = ((double)TimeUtils.timeSinceMillis(tiempoInicial)) / (double)(tiempoInicial+duracion - tiempoInicial);
        return tiempoActual > 1 ? 1 : tiempoActual;
    }
    
}