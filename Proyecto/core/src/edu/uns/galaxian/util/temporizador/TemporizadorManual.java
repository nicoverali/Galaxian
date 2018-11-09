package edu.uns.galaxian.util.temporizador;

public class TemporizadorManual {

	private float tiempo;
    private float objetivo;

    public TemporizadorManual(float milisegundos){
        objetivo = milisegundos;
        tiempo = 0;
    }

    public void contarTiempo(float tiempoTranscurrido){
    	tiempo += tiempoTranscurrido;
    }

    public boolean tiempoCumplido(){
        return tiempo>objetivo;
    }
	
}