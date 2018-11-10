package edu.uns.galaxian.ia.tareas.inteligencia.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.acciones.*;
import edu.uns.galaxian.ia.tareas.composiciones.Secuencia;
import edu.uns.galaxian.ia.tareas.composiciones.Selector;
import edu.uns.galaxian.ia.tareas.condiciones.CondicionEscapeKamikaze;
import edu.uns.galaxian.ia.tareas.decorators.HastaCondicion;

public class InteligenciaKamikaze<T extends Enemigo> extends Tarea<T> {

    private Tarea<T> enemigoTarea;

    public InteligenciaKamikaze(Blackboard<T> blackboard) {
        super(blackboard);
        enemigoTarea = construirInteligencia();
    }

    private Tarea<T> construirInteligencia(){

        Perseguir<T> perseguirObjetivo = new Perseguir<>(blackboard);
        MirarA<T> mirarAlJugador = new MirarA<>(blackboard);
        Secuencia<T> perseguirYMirar = new Secuencia<>();
        perseguirYMirar.addPrimeraTarea(perseguirObjetivo);
        perseguirYMirar.addUltimaTarea(mirarAlJugador);

        CondicionEscapeKamikaze<T> condicionKamikaze = new CondicionEscapeKamikaze<>(blackboard);
        HastaCondicion<T> kamikazeHastaCondicionEscape = new HastaCondicion<>(blackboard, perseguirYMirar, condicionKamikaze, true);

        AlinearRotacion<T> mirarAbajo = new AlinearRotacion<>(blackboard, 270);
        SeekPosicion<T> escaparAbajo = new SeekPosicion<>(blackboard, new Vector2(Gdx.graphics.getWidth()/2, -500));
        Secuencia<T> escape = new Secuencia<>();
        escape.addPrimeraTarea(mirarAbajo);
        escape.addUltimaTarea(escaparAbajo);

        Selector<T> tareaRaiz = new Selector<>();
        tareaRaiz.addPrimeraTarea(kamikazeHastaCondicionEscape);
        tareaRaiz.addUltimaTarea(escape);

        return tareaRaiz;
    }

    public boolean realizar(float delta) {
        return enemigoTarea.realizar(delta);
    }
}
