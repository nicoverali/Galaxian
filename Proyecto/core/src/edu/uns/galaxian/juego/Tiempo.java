package edu.uns.galaxian.juego;

import java.util.concurrent.TimeUnit;

public class Tiempo {
	
	private long tiempoInicial;
	
	public Tiempo() {
		tiempoInicial = System.currentTimeMillis(); // Inicializacion por defecto
	}
	
	public void iniciar() {
		tiempoInicial = System.currentTimeMillis();
	}

	public int getHora() {
		int milisegundos = (int) (System.currentTimeMillis() - tiempoInicial);
		int hora = milisegundos/3600000;
		return hora;
	}
	
	public int getMinutos() {
		int milisegundos = (int) (System.currentTimeMillis() - tiempoInicial);
		int restohora = milisegundos%3600000;
		int minuto = restohora/60000;
		return minuto;
	}
	
	public int getSegundos() {
		int milisegundos = (int) (System.currentTimeMillis() - tiempoInicial);
		int restohora = milisegundos%3600000;
		int restominuto = restohora%60000;
		int segundos = restominuto/1000;
		return segundos;
	}

	public float getTiempoEnHoras() {
		float tiempoTranscurrido = System.currentTimeMillis()-tiempoInicial;
		float horas = TimeUnit.MILLISECONDS.toHours((long) tiempoTranscurrido);
		return horas;
	}
	
	public float getTiempoEnMinutos() {
		float tiempoTranscurrido = System.currentTimeMillis()-tiempoInicial;
		float minutos = TimeUnit.MILLISECONDS.toMinutes((long) tiempoTranscurrido);
		return minutos;
	}
	
	public float getTiempoEnSegundos() {
		float tiempoTranscurrido = System.currentTimeMillis()-tiempoInicial;
		float segundos = TimeUnit.MILLISECONDS.toSeconds((long) tiempoTranscurrido);
		return segundos;
	}
	
}
