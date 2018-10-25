package edu.uns.galaxian.ia.inteligencias;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.ia.autonomo.AutonomoDinamico;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.tarea.acciones.PathFollowSimple;
import edu.uns.galaxian.ia.utils.SteeringManager;
import edu.uns.galaxian.util.camino.CaminoSimple;
import edu.uns.galaxian.util.camino.simple.CaminoAleatorio;
import edu.uns.galaxian.util.camino.simple.CaminoCircular;
import edu.uns.galaxian.util.enums.Direccion;

import java.util.ArrayList;
import java.util.List;

public class InteligenciaDeDesarrollo implements InteligenciaArtificial {

    private AutonomoDinamico autonomoDinamico;
    private SteeringManager steeringManager;
    private GameObject target;
    private CaminoSimple camino;
    private PathFollowSimple<AutonomoDinamico> pathFollow;
    private PathFollowSimple<AutonomoDinamico> pathFollow2;
    private PathFollowSimple<AutonomoDinamico> pathFollow3;


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
        pathFollow = new PathFollowSimple<>(new Blackboard<>(autonomoDinamico), new CaminoCircular(autonomoDinamico.getPosicion(), 250, Direccion.IZQUIERDA, true, 85424), 2);
        pathFollow2 = new PathFollowSimple<>(new Blackboard<>(autonomoDinamico), new CaminoCircular(autonomoDinamico.getPosicion(), 100, Direccion.ARRIBA, false, 270), 3);
        pathFollow3 = new PathFollowSimple<>(new Blackboard<>(autonomoDinamico), new CaminoAleatorio(autonomoDinamico.getPosicion(), Direccion.ARRIBA, Gdx.graphics.getWidth()-500, 700, 70), 1);
    }

    public void pensar(float delta) {
        /*if(pathFollow.realizar(delta)){

        }else{
            pathFollow2.realizar(delta);
        }*/
        pathFollow3.realizar(delta);
        float steeringAngular = steeringManager.mirarA(autonomoDinamico, target);
        autonomoDinamico.setRotacion(autonomoDinamico.getRotacion()+steeringAngular * Gdx.graphics.getDeltaTime());
        ((Enemigo)autonomoDinamico).disparar();
    }
}
