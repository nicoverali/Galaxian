package edu.uns.galaxian.util.temporizador;

import com.badlogic.gdx.utils.TimeUtils;

public class Temporizador {

    private long tiempoDeInicio;
    private int objetivo;

    public Temporizador(){
        tiempoDeInicio = System.currentTimeMillis();
        objetivo = 0;
    }

    /**
     * Inicia el temporizador con los milisegundos dados
     * @param milisegundos Milisegundos que contara el temporizador
     */
    public void iniciar(int milisegundos){
        tiempoDeInicio = System.currentTimeMillis();
        objetivo = milisegundos;
    }

    /**
     * Verifica si se cumplio el tiempo
     * @return Verdadero si el tiempo ya se cumplio, falso en caso contrario
     */
    public boolean tiempoCumplido(){
        return TimeUtils.timeSinceMillis(tiempoDeInicio) >= objetivo;
    }
}