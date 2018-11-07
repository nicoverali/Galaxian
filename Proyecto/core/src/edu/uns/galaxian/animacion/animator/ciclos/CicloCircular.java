package edu.uns.galaxian.animacion.animator.ciclos;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.animacion.animator.CicloAnimator;

public class CicloCircular implements CicloAnimator {

    private long tiempoInicial;
    private long duracion;
    private int vueltas;
    private int vueltasRealizadas;
    private boolean terminarAlFinal;
    private boolean finalizado;

    public CicloCircular(int cantidadVueltas, boolean terminarAlFinalDelCiclo) throws IllegalArgumentException{
        if(cantidadVueltas < 0) throw new IllegalArgumentException("La cantidad de vueltas no puede ser negativa.");
        vueltas = cantidadVueltas > 0 ? cantidadVueltas : -1;
        terminarAlFinal = terminarAlFinalDelCiclo;
        finalizado = false;
    }

    public CicloCircular(){
        this(0, false);
    }

    public void iniciarCiclo(long duracion) {
        this.duracion = duracion;
        tiempoInicial = TimeUtils.millis();
        vueltasRealizadas = 0;
    }

    public boolean cicloFinalizado() {
        return finalizado;
    }

    public double getTiempoActual() {
        long tiempoTranscurrido = TimeUtils.timeSinceMillis(tiempoInicial);
        if(vueltasRealizadas == vueltas){
            if(tiempoTranscurrido < duracion && terminarAlFinal){
                return Math.abs(-Math.abs((double)tiempoTranscurrido-duracion)+duracion) / (double)duracion;
            }
            finalizado = true;
            return terminarAlFinal ? 1 : 0;
        }
        if(tiempoTranscurrido >= duracion*2){
            tiempoInicial += duracion*2;
            vueltasRealizadas++;
            return 0;
        }
        return Math.abs(-Math.abs((double)tiempoTranscurrido-duracion)+duracion) / (double)duracion;
    }
}
