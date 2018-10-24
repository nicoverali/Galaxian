package edu.uns.galaxian.ia.steering;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.util.camino.CaminoSimple;

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

    public float align(float rotacionObjetivo, float radioDeLlegada){
        float rawRotation = rotacionObjetivo - autonomo.getRotacion();
        float rotacion = mapear(rawRotation, 0, 360, 180, -180);
        float magnitudRotacion = Math.abs(rawRotation);
        float rotacionFinal;
        if(magnitudRotacion < 1f){
            return 0;
        }
        else if(magnitudRotacion > radioDeLlegada){
            rotacionFinal = autonomo.getSteeringMaximo()*50;
        }
        else{
            rotacionFinal = autonomo.getSteeringMaximo()*50*magnitudRotacion/radioDeLlegada;
        }
        rotacionFinal *= rotacion / magnitudRotacion;
        float steeringAngular = rotacionFinal - rotacionObjetivo;
        return rotacionFinal;
    }

    public float face(GameObject target){
        Vector2 direccion = target.getPosicion().sub(autonomo.getPosicion());
        if(direccion.len() == 0){
            return 0;
        }
        return align(direccion.angle(), 50);
    }

    public Vector2 followPath(CaminoSimple camino, float radioDeLlegada){
        Vector2 paradaActual = camino.getParadaActual();
        float distancia = autonomo.getPosicion().dst(paradaActual);
        if(distancia < radioDeLlegada){
            paradaActual = camino.avanzar();
        }
        return arrive(paradaActual, radioDeLlegada);
    }


    private float mapear(float valor, float A, float B, float a, float b){
        if(valor > 180){
            return valor-360;
        }
        else {
            return valor;
        }
    }
}
