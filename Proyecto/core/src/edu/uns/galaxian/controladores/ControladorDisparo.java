package edu.uns.galaxian.controladores;

import java.util.List;

import edu.uns.galaxian.entidades.inanimadas.Disparo;

public abstract class ControladorDisparo implements ControladorEntidad {
    
	 private List<Disparo> disparos;
	 
	 public void agregarDisparo(Disparo disparo) {};
}
