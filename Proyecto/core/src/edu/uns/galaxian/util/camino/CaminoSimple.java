package edu.uns.galaxian.util.camino;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaminoSimple {

    private List<Vector2> paradas;
    private int paradaActual;

    public CaminoSimple(List<Vector2> paradas){
        this.paradas = paradas;
        paradaActual = 0;
    }

    public CaminoSimple(){
        paradas = new ArrayList<>();
        paradaActual = 0;
    }

    /**
     * Retorna la cantidad de paradas
     * @return Cantidad de paradas
     */
    public int getCantidadParadas(){
        return paradas.size();
    }

    /**
     * Verifica si se finalizo o no el camino
     * @return Verdadero si el camino finalizo, falso en caso contrario
     */
    public boolean caminoFinalizado(){
        return paradaActual+1 == paradas.size();
    }

    /**
     * Avanza el camino a la parada siguiente y la retorna
     * @return Parada siguiente
     * @throws IllegalStateException Si el camino ya finalizo
     */
    public Vector2 avanzar() throws IllegalStateException{
        if(paradaActual+1 == paradas.size()){
            throw new IllegalStateException("El camino ya finalizo, no es posible avanzar.");
        }
        return  paradas.get(++paradaActual);
    }

    /**
     * Retorna la parada actual
     * @return Parada actual
     */
    public Vector2 getParadaActual(){
        return paradas.get(paradaActual);
    }

    /**
     * Reinicia el camino a la primer parada
     */
    public void reinciarCamino(){
        paradaActual = 0;
    }

    /**
     * Invierte las paradas del camino.
     * La parada actual seguira siendo la misma.
     */
    public void invertirCamino(){
        Collections.reverse(paradas);
        paradaActual = paradas.size() - paradaActual;
    }

    /**
     * Agrega una nueva parada al final del camino
     * @param parada Nueva parada
     */
    public void agregarUltimaParada(Vector2 parada){
        paradas.add(parada);
    }

    /**
     * Agrega una nueva parada al comienzo del camino
     * @param parada Nueva parada
     */
    public void agregarPrimerParada(Vector2 parada){
        paradas.add(0, parada);
        if(paradaActual > 0) paradaActual++;
    }

}
