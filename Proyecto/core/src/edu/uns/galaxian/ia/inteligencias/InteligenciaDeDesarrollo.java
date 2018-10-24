package edu.uns.galaxian.ia.inteligencias;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.utils.SteeringManager;
import edu.uns.galaxian.util.camino.CaminoSimple;

import java.util.ArrayList;
import java.util.List;

public class InteligenciaDeDesarrollo implements InteligenciaArtificial {

    private AutonomoDinamico autonomoDinamico;
    private SteeringManager steeringManager;
    private GameObject target;
    private CaminoSimple camino;

    public InteligenciaDeDesarrollo(AutonomoDinamico autonomoDinamico, GameObject target){
        this.autonomoDinamico = autonomoDinamico;
        this.target = target;
        this.steeringManager = new SteeringManager();
        Vector2 parada1 = new Vector2(100,100);
        Vector2 parada2 = new Vector2(200,100);
        Vector2 parada3 = new Vector2(200,350);
        Vector2 parada4 = new Vector2(600,50);
        Vector2 parada5 = new Vector2(700,150);
        Vector2 parada6 = new Vector2(600,250);
        List<Vector2> paradas = new ArrayList<>(6);
        paradas.add(parada1);
        paradas.add(parada2);
        paradas.add(parada3);
        paradas.add(parada4);
        paradas.add(parada5);
        paradas.add(parada6);
        camino = new CaminoSimple(paradas);
    }

    public void pensar(float delta) {
        Vector2 steering = steeringManager.followPath( autonomoDinamico, camino, 20);
        autonomoDinamico.setPosicion(autonomoDinamico.getPosicion().add(autonomoDinamico.getVelocidad().scl(Gdx.graphics.getDeltaTime())));
        autonomoDinamico.setVelocidad(autonomoDinamico.getVelocidad().add(steering).limit(autonomoDinamico.getVelocidadMaxima()));
        float steeringAngular = steeringManager.mirarA(autonomoDinamico, target);
        autonomoDinamico.setRotacion(autonomoDinamico.getRotacion()+steeringAngular * Gdx.graphics.getDeltaTime());
        ((Enemigo)autonomoDinamico).disparar();
    }
}
