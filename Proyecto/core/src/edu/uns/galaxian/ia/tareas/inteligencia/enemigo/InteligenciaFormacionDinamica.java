package edu.uns.galaxian.ia.tareas.inteligencia.enemigo;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.acciones.ArrivePosicion;
import edu.uns.galaxian.ia.tareas.acciones.PathFollowSimple;
import edu.uns.galaxian.ia.tareas.inteligencia.transicion.TransicionTarea;
import edu.uns.galaxian.ia.utils.SteeringManager;
import edu.uns.galaxian.util.camino.CaminoSimple;
import edu.uns.galaxian.util.camino.simple.CaminoCircular;
import edu.uns.galaxian.util.enums.Direccion;

public class InteligenciaFormacionDinamica<T extends Enemigo> extends Tarea<T> {

    private Vector2 posicionEnFormacion;
    private ArrivePosicion<T> arrive;

    public InteligenciaFormacionDinamica(Blackboard<T> blackboard, Vector2 posicionEnFormacion) {
        super(blackboard);
        this.posicionEnFormacion = posicionEnFormacion;
        arrive = new ArrivePosicion<>(blackboard, posicionEnFormacion);
    }

    public InteligenciaFormacionDinamica(Vector2 posicionEnFormacion) {
        this.posicionEnFormacion = posicionEnFormacion;
        arrive = new ArrivePosicion<>(blackboard, posicionEnFormacion);
    }

    public boolean realizar(float delta) {
        return arrive.realizar(delta);
    }

    /*public void transicionar(InteligenciaArtificial<T> nuevaInteligencia) {
        CaminoSimple camino = new CaminoCircular(enemigo.getPosicion(), 150, Direccion.DERECHA, 180);
        PathFollowSimple<T> pathFollow = new PathFollowSimple<>(new Blackboard<>(enemigo), camino, 1);
        enemigo.setTareaInteligencia(new TransicionTarea<>(enemigo, pathFollow, nuevaInteligencia));
    }*/
}
