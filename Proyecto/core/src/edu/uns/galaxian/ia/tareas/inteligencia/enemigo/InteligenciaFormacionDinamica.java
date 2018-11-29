package edu.uns.galaxian.ia.tareas.inteligencia.enemigo;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.acciones.ArrivePosicion;

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

}