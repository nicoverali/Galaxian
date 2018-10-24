package edu.uns.galaxian.ia.steering;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.entidades.status.GameObject;

public class SteeringManager {

    private AutonomoDinamico autonomo;

    public SteeringManager(AutonomoDinamico autonomo){
        this.autonomo = autonomo;
    }

    public Vector2 seek(Vector2 position){
        Vector2 steering = position.cpy().sub(autonomo.getPosicion());
        steering.setLength(autonomo.getSteeringMaximo());
        return steering;
    }

    public Vector2 flee(Vector2 position){
        Vector2 steering = autonomo.getPosicion().sub(position);
        steering.setLength(autonomo.getSteeringMaximo());
        return steering;
    }

    public Vector2 arrive(Vector2 position, float radioDeLLegada){
        Vector2 direccionDeseada = position.cpy().sub(autonomo.getPosicion());
        float velocidadAObjetivo;
        float distancia = direccionDeseada.len();
        if(distancia == 0){
            return Vector2.Zero.cpy();
        }
        else if(distancia > radioDeLLegada){
            velocidadAObjetivo = autonomo.getVelocidadMaxima();
        }
        else{
            velocidadAObjetivo = (autonomo.getVelocidadMaxima() * distancia) / radioDeLLegada;
        }
        Vector2 velocidadFinal = direccionDeseada.setLength(velocidadAObjetivo);
        Vector2 steering = velocidadFinal.sub(autonomo.getVelocidad());
        steering.limit(autonomo.getSteeringMaximo());
        return steering;
    }

    public Vector2 pursue(GameObject objetivo){
        final float PREDICCION = 5;
        Vector2 direccionDeseada = objetivo.getPosicion().sub(autonomo.getPosicion());
        float distancia = direccionDeseada.len();
        float velocidadActual = autonomo.getVelocidad().len();
        float prediccion;
        if(velocidadActual <= distancia/PREDICCION){
            prediccion = PREDICCION;
        }
        else{
            prediccion = distancia / velocidadActual;
        }
        Vector2 positionFutura = objetivo.getPosicion().add(objetivo.getVelocidad().scl(prediccion));
        System.out.println(objetivo.getVelocidad().scl(PREDICCION).len());
        return seek(positionFutura);
    }


    private float mapear(float valor, float a, float b, float c, float d){
        return c + ((valor-a)*(d-c)/(c-a));
    }
}
