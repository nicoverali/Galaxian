package edu.uns.galaxian.ia.inteligencias.enemigo;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.btree.acciones.PathFollowSimple;
import edu.uns.galaxian.ia.inteligencias.transicion.TransicionTarea;
import edu.uns.galaxian.ia.utils.SteeringManager;
import edu.uns.galaxian.util.camino.CaminoSimple;
import edu.uns.galaxian.util.camino.simple.CaminoCircular;
import edu.uns.galaxian.util.enums.Direccion;

public class InteligenciaFormacionDinamica<T extends Enemigo> implements InteligenciaArtificial<T> {

    private T enemigo;
    private Vector2 posicionEnFormacion;

    public InteligenciaFormacionDinamica(T enemigo, Vector2 posicionEnFormacion){
        this.enemigo = enemigo;
        this.posicionEnFormacion = posicionEnFormacion;
    }


    public void pensar(float delta) {
        SteeringManager steering = new SteeringManager();
        Vector2 steeringVeotor = steering.arrive(enemigo, posicionEnFormacion, 50);
        enemigo.setVelocidad(enemigo.getVelocidad().add(steeringVeotor).limit(enemigo.getVelocidadMaxima()));
        enemigo.setPosicion(enemigo.getPosicion().add(enemigo.getVelocidad().scl(delta)));
        float steeringAngular = steering.alinear(enemigo, 270);
        enemigo.setRotacion(enemigo.getRotacion() + steeringAngular * delta);
    }

    public void transicionar(InteligenciaArtificial<T> nuevaInteligencia) {
        CaminoSimple camino = new CaminoCircular(enemigo.getPosicion(), 150, Direccion.DERECHA, 180);
        PathFollowSimple<T> pathFollow = new PathFollowSimple<>(new Blackboard<>(enemigo), camino, 1);
        enemigo.setInteligencia(new TransicionTarea<>(enemigo, pathFollow, nuevaInteligencia));
    }
}
