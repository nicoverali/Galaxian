package edu.uns.galaxian.util.camino;

import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;
import java.util.List;

public class Camino {

    public static final int INICIO = 0;
    public static final int FIN = 1;

    private List<Vector2> camino;
    private int[] segmentoActual;

    public Camino(List<Vector2> camino){
        this.camino = camino;
        segmentoActual = new int[]{0,1};
    }

    public Camino(){
        camino = new LinkedList<>();
        segmentoActual = new int[]{0,1};
    }

    /**
     * Inicia el camino en el segmento mas cercano.
     * Retorna el el segmento mas cercano
     * @param posicionInicial Posicion inicial
     * @return Segmento mas cercano desde la posicion inicial
     */
    public Vector2[] iniciarDesde(Vector2 posicionInicial){
        int[] mejorSegmento = new int[2];
        Vector2 ini, fin, puntoNormal;
        float distanciaActual;
        float distanciaMasCorta = Float.MAX_VALUE;
        for(int i = 0; i < camino.size()-1; i++){
            ini = camino.get(i);
            fin = camino.get(i+1);
            puntoNormal = getPuntoNormal(posicionInicial, ini, fin);
            distanciaActual = estaEnSegmento(puntoNormal, ini, fin) ?
                Vector2.dst2(posicionInicial.x, posicionInicial.y, puntoNormal.x, puntoNormal.y):
                Vector2.dst2(posicionInicial.x, posicionInicial.y, ini.x, ini.y);
            if(distanciaActual < distanciaMasCorta){
                distanciaMasCorta = distanciaActual;
                mejorSegmento[INICIO] = i;
                mejorSegmento[FIN] = i+1;
            }
        }
        this.segmentoActual = mejorSegmento;
        return new Vector2[]{camino.get(mejorSegmento[INICIO]).cpy(), camino.get(mejorSegmento[FIN]).cpy()};
    }

    /**
     * Avanza el camino al segmento siguiente.
     * @return Segmento siguiente
     * @throws IllegalStateException Si el camino ya llego al final
     */
    public Vector2[] avanzar() throws IllegalStateException{
        if(segmentoActual[FIN] == camino.size()-1)
            throw new IllegalStateException("No es posible avanzar, ya se llegó al final del camino.");
        return new Vector2[]{camino.get(++segmentoActual[INICIO]).cpy(), camino.get(++segmentoActual[FIN]).cpy()};
    }

    /**
     * Retrocede el camino al segmento anterior.
     * @return Segmento anterior
     * @throws IllegalStateException Si el camino esta en el inicio
     */
    public Vector2[] retroceder() throws IllegalStateException{
        if(segmentoActual[INICIO] == 0)
            throw new IllegalStateException("No es posible retroceder más alla del inicio del camino.");
        return new Vector2[]{camino.get(--segmentoActual[INICIO]).cpy(), camino.get(--segmentoActual[FIN]).cpy()};
    }

    /**
     * Retorna el segmento actual del camino
     * @return Segmento actual
     */
    public Vector2[] getSegmentoActual(){
        return new Vector2[]{camino.get(segmentoActual[INICIO]).cpy(), camino.get(segmentoActual[FIN]).cpy()};
    }

    /**
     * Retorna el segmento siguiente del actual
     * @return Segmento siguiente
     */
    public Vector2[] getSegmentoSiguiente(){
        if(segmentoActual[FIN] < camino.size()){
            return new Vector2[]{camino.get(segmentoActual[INICIO]+1).cpy(), camino.get(segmentoActual[FIN]+1).cpy()};
        }
        return null;
    }

    /**
     * Retorna el segmento anterior al actual
     * @return Segmento anterior
     */
    public Vector2[] getSegmentoAnterior(){
        if(segmentoActual[INICIO] > 0){
            return new Vector2[]{camino.get(segmentoActual[INICIO]-1).cpy(), camino.get(segmentoActual[FIN]-1).cpy()};
        }
        return null;
    }

    /**
     * Verifica si el camino llego al final o no
     * @return Verdadero si se llego al final, falso en caso contrario
     */
    public boolean caminoFinalizado(){
        return segmentoActual[FIN] == camino.size()-1;
    }

    /**
     * Agrega una nueva parada al final del camino
     * @param parada Nueva parada
     */
    public void agregarUltimaParada(Vector2 parada){
        camino.add(camino.size(), parada);
    }

    /**
     * Agrega una nueva parada al inicio del camino
     * @param parada Nueva parada
     */
    public void agregarPrimerParada(Vector2 parada){
        camino.add(parada);
        if(segmentoActual[INICIO] > 0){
            segmentoActual[INICIO]++;
            segmentoActual[FIN]++;
        }
    }

    /**
     * Remueve la ultima parada del camino
     * @throws IllegalStateException Si el segmento actual del camino esta conformado por la ultima parada
     */
    public void removerUltimaParada() throws IllegalStateException{
        if(segmentoActual[FIN] == camino.size()-1)
            throw new IllegalStateException("No se puede eliminar una parada del segmento en el cual se esta actualmente.");
        camino.remove(camino.size()-1);
    }

    /**
     * Remueve la primer parada del camino
     * @throws IllegalStateException Si el segmento actual del camino esta conformado por la primer parada
     */
    public void removerPrimerParada() throws IllegalStateException{
        if(segmentoActual[INICIO] == 0)
            throw new IllegalStateException("No se puede eliminar una parada del segmento en el cual se esta actualmente.");
        camino.remove(0);
        if(segmentoActual[INICIO] > 0){
            segmentoActual[INICIO]--;
            segmentoActual[FIN]--;
        }
    }

    /**
     * Vuelve el camino al inicio, es decir, el segmento
     * actual sera el primer segmento del camino
     */
    public void reiniciarCamino(){
        segmentoActual[INICIO] = 0;
        segmentoActual[FIN] = 1;
    }

    /**
     * Retorna el punto normal sobre el segmento recibido a partir
     * de la posicion dada.
     * @param posicion Posicion sobre la cual se calcula el punto normal
     * @param segInicio Punto inicial del segmento
     * @param segFin Punto final del segmento
     * @return Posicion del punto normal
     */
    public static Vector2 getPuntoNormal(Vector2 posicion, Vector2 segInicio, Vector2 segFin){
        Vector2 segPosicion = posicion.cpy().sub(segInicio);
        Vector2 segmentoNorm = segFin.cpy().sub(segInicio).nor();
        return segmentoNorm.scl(segPosicion.dot(segmentoNorm));
    }

    /**
     * Verifica si una dada posicion pertenece al segmento recibido.
     * @param posicion Posicion sobre la cual se realiza la verificacion
     * @param segInicio Punto inicial del segmento
     * @param segFin Punto final del segmento
     * @return Verdadero si la posicion esta en el segmento, falso en caso contrario
     */
    public static boolean estaEnSegmento(Vector2 posicion, Vector2 segInicio, Vector2 segFin){
        final float TOLERANCIA = 0.0002f;
        Vector2 vectorSeg = segFin.cpy().sub(segInicio);
        Vector2 vectorIniPos = posicion.cpy().sub(segInicio);
        Vector2 vectorPosFin = segFin.cpy().sub(posicion);
        return Math.abs((vectorSeg.len2() - vectorIniPos.len2() - vectorPosFin.len2())) < TOLERANCIA;
    }
}