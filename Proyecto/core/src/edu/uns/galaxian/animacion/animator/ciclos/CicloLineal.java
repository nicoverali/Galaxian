package edu.uns.galaxian.animacion.animator.ciclos;

import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.animacion.animator.CicloAnimator;

public class CicloLineal implements CicloAnimator {

    private long tiempoInicial;
    private long duracion;
    private int pasadas;
    private int pasadasRealizadas;
    private boolean terminarAlFinal;

    public CicloLineal(int cantidadPasadas, boolean terminarAlFinalDelCiclo) throws IllegalArgumentException{
        if(cantidadPasadas < 0) throw new IllegalArgumentException("La cantidad de pasadas no puede ser negativa.");
        pasadas = cantidadPasadas > 0 ? cantidadPasadas : -1;
        terminarAlFinal = terminarAlFinalDelCiclo;
    }

    public CicloLineal(){
        this(0, false);
    }

    public void iniciarCiclo(long duracion) {
        this.duracion = duracion;
        tiempoInicial = TimeUtils.millis();
        pasadasRealizadas = 0;
    }

    public boolean cicloFinalizado() {
        return pasadasRealizadas == pasadas;
    }

    public double getTiempoActual() {
        long tiempoTranscurrido = TimeUtils.timeSinceMillis(tiempoInicial);
        if(tiempoTranscurrido > duracion + (duracion * pasadasRealizadas)){
            pasadasRealizadas++;
        }
        if(pasadasRealizadas == pasadas){
            if(terminarAlFinal){
                return 1;
            }
            return 0;
        }
        return (double)tiempoTranscurrido/(double)duracion - Math.floor((double)tiempoTranscurrido/(double)duracion);
    }

}
