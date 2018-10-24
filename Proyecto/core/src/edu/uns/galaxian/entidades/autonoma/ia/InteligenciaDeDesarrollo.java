package edu.uns.galaxian.entidades.autonoma.ia;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.ia.steering.SteeringManager;

public class InteligenciaDeDesarrollo implements InteligenciaArtificial {

    private AutonomoDinamico autonomoDinamico;
    private SteeringManager steeringManager;
    private GameObject target;

    public InteligenciaDeDesarrollo(AutonomoDinamico autonomoDinamico, GameObject target){
        this.autonomoDinamico = autonomoDinamico;
        this.target = target;
        this.steeringManager = new SteeringManager(autonomoDinamico);
    }

    public void pensar(Entidad estado) {
        /*Vector2 steering = steeringManager.pursue(target);
        autonomoDinamico.setPosicion(autonomoDinamico.getPosicion().add(autonomoDinamico.getVelocidad().scl(Gdx.graphics.getDeltaTime())));
        autonomoDinamico.setVelocidad(autonomoDinamico.getVelocidad().add(steering).limit(autonomoDinamico.getVelocidadMaxima()));*/
        float steeringAngular = steeringManager.face(target);
        autonomoDinamico.setRotacion(autonomoDinamico.getRotacion()+steeringAngular * Gdx.graphics.getDeltaTime());
        ((Enemigo)autonomoDinamico).disparar();
    }
}
