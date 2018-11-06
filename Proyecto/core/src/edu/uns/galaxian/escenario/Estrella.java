package edu.uns.galaxian.escenario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import java.util.Random;

public class Estrella {

    // Radio maximo de las estrellas
    private static final float RADIO = 5.5f;
    // Factor por el que se multiplica la velocidad de profundidad
    private static final float FACTOR_VELOCIDAD = 0.003f;
    // Altera que tan rapido empiezan a desvanecer las estrellas
    private static final int FACTOR_ALPHA = 1;
    // La profundidad maxima
    private static final int LIMITE_Z = 16;
    private static final Vector2 ORIGEN = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

    private Random ran;
    private Vector2 posicionAnterior;
    private Vector3 posicion;
    private float alpha;

    public Estrella(){
        ran = new Random();
        Vector2 xyRandom = generarPosicionRandom();
        posicion = new Vector3(xyRandom.x, xyRandom.y, ran.nextInt(LIMITE_Z-1)+1);
        posicionAnterior = new Vector2(posicion.x, posicion.y);
        alpha = 1;
    }

    // TODO Antes el vector direccion normalizaba al del parametro, en realidad se debe verificar que todas las componentes sean 1, 0 o -1
    public void mover(Vector3 direccion, float velocidad, float delta){
        posicionAnterior.set(posicion.x, posicion.y);
        posicion.add(direccion.x * velocidad/posicion.z * delta, direccion.y * velocidad/posicion.z * delta, 0);
        if(direccion.z != 0) {
            posicion.add(0, 0, direccion.z * velocidad * FACTOR_VELOCIDAD * posicion.z * delta);
            Vector2 origenFinal = ORIGEN.cpy().add(direccion.x * velocidad, direccion.y * velocidad);
            Vector2 direccionAlOrigen = origenFinal.sub(posicion.x, posicion.y).limit2(1).scl(direccion.z);
            posicion.add(direccionAlOrigen.x * velocidad / posicion.z * delta, direccionAlOrigen.y * velocidad / posicion.z * delta, 0);
            verificarExtremosConZ(origenFinal);
        }else{
            verificarExtremos();
        }
        alpha = (float)-Math.exp(-(FACTOR_ALPHA * posicion.z-FACTOR_ALPHA))+1;
    }

    public void dibujar(ShapeRenderer renderer){
        renderer.setColor(255, 255, 255, alpha);
        renderer.circle(posicion.x, posicion.y, RADIO / posicion.z);
        renderer.rectLine(posicionAnterior.x, posicionAnterior.y, posicion.x, posicion.y, RADIO / posicion.z);
    }

    private void verificarExtremos(){
        int ancho = Gdx.graphics.getWidth();
        int alto = Gdx.graphics.getHeight();
        if(posicion.x > ancho){
            int posY = ran.nextInt(alto);
            posicion.set(0, posY, ran.nextInt(LIMITE_Z-1)+1);
            posicionAnterior.set(0, posY);
        }
        else if(posicion.x < 0){
            int posY = ran.nextInt(alto);
            posicion.set(ancho, posY, ran.nextInt(LIMITE_Z-1)+1);
            posicionAnterior.set(ancho, posY);
        }
        if(posicion.y < 0){
            int posX = ran.nextInt(ancho);
            posicion.set(posX, alto, ran.nextInt(LIMITE_Z-1)+1);
            posicionAnterior.set(posX, alto);
        }
        else if(posicion.y > alto){
            int posX = ran.nextInt(ancho);
            posicion.set(posX, 0, ran.nextInt(LIMITE_Z-1)+1);
            posicionAnterior.set(posX, 0);
        }
    }

    private void verificarExtremosConZ(Vector2 origen) {
        final float TOLERANCIA = 0.1f;
        if (posicion.z < 1 + TOLERANCIA) {
            Vector2 xyRandom = generarPosicionRandom();
            // TODO Arreglar eso de ahi
            posicion.set(xyRandom.x, xyRandom.y, ran.nextInt(10) + LIMITE_Z-10);
            posicionAnterior = xyRandom;
        }
        else if(posicion.z > LIMITE_Z){
            Vector2 xyRandom;
            do{
                xyRandom = generarPosicionRandom();
            }while(origen.dst(xyRandom) < 150);
            posicion.set(xyRandom.x, xyRandom.y, ran.nextInt(4)+1);
            posicionAnterior = xyRandom;
        }
    }

    private Vector2 generarPosicionRandom(){
        return new Vector2(ran.nextInt(Gdx.graphics.getWidth()), ran.nextInt(Gdx.graphics.getHeight()));
    }
}
