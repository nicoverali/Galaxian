package edu.uns.galaxian.ia.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.util.camino.CaminoSimple;

public class SteeringManager {

    /**
     * Da al autonomo la fuerza necesaria para
     * dirigirse hacia su objetivo
     * @param autonomo Autonomo huesped
     * @param objetivo Objetivo del autonomo
     * @return Fuerza para dirigirse hacia objetivo
     */
    public Vector2 seek(AutonomoDinamico autonomo, GameObject objetivo){
        return this.seek(autonomo, objetivo.getPosicion());
    }

    /**
     * Da al autonomo la fuerza necesaria para dirigirse
     * hacia su posicion objetivo
     * @param autonomo Autonomo huesped
     * @param position Posicion objetivo del autonomo
     * @return Fuerza para dirigirse hacia la posicion objetivo
     */
    public Vector2 seek(AutonomoDinamico autonomo, Vector2 position){
        Vector2 direccionDeseada = position.cpy().sub(autonomo.getPosicion()).setLength(autonomo.getVelocidadMaxima());
        Vector2 steering = direccionDeseada.sub(autonomo.getVelocidad());
        return steering.limit(autonomo.getSteeringMaximo());
    }

    /**
     * Retorna la fuerza necesaria para que el autonomo
     * huya del objetivo
     * @param autonomo Autonomo huesped
     * @param objetivo Objetivo de la cual el autonomo quiere huir
     * @return Fuerza para huir del objetivo
     */
    public Vector2 flee(AutonomoDinamico autonomo, GameObject objetivo){
        return this.flee(autonomo, objetivo.getPosicion());
    }

    /**
     * Retorna la fuerza necesaria para que el autonomo
     * huya de la posicion objetivo
     * @param autonomo Autonomo huesped
     * @param position Posicion objetivo de la cual el autonomo quiere huir
     * @return Fuerza para huir de la posicion objetivo
     */
    public Vector2 flee(AutonomoDinamico autonomo, Vector2 position){
        Vector2 steering = autonomo.getPosicion().sub(position);
        return steering.limit(autonomo.getSteeringMaximo());
    }

    /**
     * Similar a {@link #seek(AutonomoDinamico, GameObject)}, pero a medida
     * que el autonomo se acerca al objetivo disminuye su
     * velocidad hasta quedarse quieto
     * @param autonomo Autonomo huesped
     * @param objetivo Objetivo del autonomo
     * @param radioDeLlegada Radio a partir del cual el autonomo desacelerara
     * @return Fuerza necesaria para llegar al objetivo
     */
    public Vector2 arrive(AutonomoDinamico autonomo, GameObject objetivo, float radioDeLlegada){
        return this.arrive(autonomo, objetivo.getPosicion(), radioDeLlegada);
    }

    /**
     * Similar a {@link #seek(AutonomoDinamico, Vector2)}, pero a medida
     * que el autonomo se acerca a la posicion objetivo disminuye su
     * velocidad hasta quedarse quieto
     * @param autonomo Autonomo huesped
     * @param posicion Posicion objetivo del autonomo
     * @param radioDeLlegada Radio a partir del cual el autonomo desacelerara
     * @return Fuerza necesaria para llegar a la posicion objetivo
     */
    public Vector2 arrive(AutonomoDinamico autonomo, Vector2 posicion, float radioDeLlegada){
        Vector2 direccionDeseada = posicion.cpy().sub(autonomo.getPosicion());
        float distancia = direccionDeseada.len();
        if(distancia == 0){
            return Vector2.Zero.cpy();
        }
        float velocidadDeseada = distancia > radioDeLlegada ?
                autonomo.getVelocidadMaxima() :
                (autonomo.getVelocidadMaxima() * distancia) / radioDeLlegada;
        direccionDeseada.setLength(velocidadDeseada);
        Vector2 steering = direccionDeseada.sub(autonomo.getVelocidad());
        return steering.limit(autonomo.getSteeringMaximo());
    }

    /**
     * Calcula la fuerza necesaria para que el
     * autonomo huesped persiga a su objetivo.
     * @param autonomo Autonomo huesped
     * @param objetivo Objetivo del autonomo
     * @return Fuerza para perseguir al objetivo
     */
    public Vector2 perseguir(AutonomoDinamico autonomo, GameObject objetivo){
        final float PREDICCION = 20;
        float distanciaAlObjetivo = autonomo.getPosicion().dst(objetivo.getPosicion());
        float velocidadActual = autonomo.getVelocidad().len();
        float magnitudPrediccion = velocidadActual <= distanciaAlObjetivo/PREDICCION ?
                PREDICCION :
                distanciaAlObjetivo / velocidadActual;
        Vector2 posicionFuturaDelObjetivo = objetivo.getPosicion().add(objetivo.getVelocidad().scl(magnitudPrediccion));
        return arrive(autonomo, posicionFuturaDelObjetivo, 50);
    }

    /**
     * Retorna la fuerza angular necesaria para alinear
     * la rotacion del autonomo con la rotacion del objetivo
     * @param autonomo Autonomo huesped
     * @param objetivo Objetivo del autonomo
     * @return Fuerza angular para alinear las rotaciones
     */
    public float alinear(AutonomoDinamico autonomo, GameObject objetivo){
        return this.alinear(autonomo, objetivo.getRotacion());
    }

    /**
     * Retorna la fuerza angular necesaria para alinear
     * la rotacion del autonomo con la rotacion objetivo
     * @param autonomo Autonomo huesped
     * @param rotacionObjetivo Rotacion objetivo del autonomo
     * @return Fuerza angular para alinear las rotaciones
     */
    public float alinear(AutonomoDinamico autonomo, float rotacionObjetivo){
        final int RADIO_DESACELERACION = 30;
        final float TOLERANCIA = 1f;
        final float CONSTANTE_STEERING = 0.13f;
        float rotacionDeseada = rotacionObjetivo - autonomo.getRotacion();
        // Girar para el lado mas cercano
        rotacionDeseada = Math.abs(rotacionDeseada) > 180 ?
                (rotacionDeseada % 180) * -1:
                rotacionDeseada;
        float magnitudRotacion = Math.abs(rotacionDeseada);
        if(magnitudRotacion < TOLERANCIA){
            return 0;
        }
        float rotacionFinal = magnitudRotacion > RADIO_DESACELERACION ?
                autonomo.getSteeringMaximo()*CONSTANTE_STEERING :
                autonomo.getSteeringMaximo()*CONSTANTE_STEERING*magnitudRotacion/RADIO_DESACELERACION;

        float steeringAngular = rotacionFinal * rotacionDeseada / magnitudRotacion;
        steeringAngular *= autonomo.getSteeringMaximo()*CONSTANTE_STEERING;
        return steeringAngular;
    }

    public Vector2 followPath(AutonomoDinamico autonomo, CaminoSimple camino, float radioDeLlegada){
        Vector2 paradaActual = camino.getParadaActual();
        float distancia = autonomo.getPosicion().dst(paradaActual);
        if(distancia < radioDeLlegada){
            paradaActual = camino.avanzar();
        }
        return arrive(autonomo, paradaActual, radioDeLlegada);
    }
}
