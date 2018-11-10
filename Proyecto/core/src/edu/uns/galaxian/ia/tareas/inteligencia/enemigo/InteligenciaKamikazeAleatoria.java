package edu.uns.galaxian.ia.tareas.inteligencia.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.acciones.*;
import edu.uns.galaxian.ia.tareas.composiciones.Paralela;
import edu.uns.galaxian.ia.tareas.composiciones.Secuencia;
import edu.uns.galaxian.ia.tareas.composiciones.Selector;
import edu.uns.galaxian.ia.tareas.condiciones.CondicionEscapeKamikaze;
import edu.uns.galaxian.ia.tareas.decorators.HastaCondicion;
import edu.uns.galaxian.util.camino.simple.CaminoAleatorio;
import edu.uns.galaxian.util.enums.Direccion;

import java.util.Arrays;

public class InteligenciaKamikazeAleatoria<T extends Enemigo> extends Tarea<T> {

    private Tarea<T> enemigoTarea;

    public InteligenciaKamikazeAleatoria(Blackboard<T> blackboard) {
        super(blackboard);
        enemigoTarea = construirInteligencia();
    }

    private Tarea<T> construirInteligencia(){
        T enemigo = blackboard.getAutonomo();

        // Caminos
        CaminoAleatorio caminoAleatorio = new CaminoAleatorio(enemigo.getPosicion(), Direccion.ABAJO, Gdx.graphics.getWidth()-200, 800, 150, false, 5);
        PathFollowSimple seguirCaminoAleatorio = new PathFollowSimple<>(blackboard, caminoAleatorio, 1);

        // Siempre mirar al objetivo
        MirarA<T> mirarObjetivo = new MirarA<>(blackboard);

        // Hasta que no se pase del jugador
        CondicionEscapeKamikaze<T> condicionEscapeKamikaze = new CondicionEscapeKamikaze<>(blackboard);

        // Escape
        AlinearRotacion<T> mirarAbajo = new AlinearRotacion<>(blackboard, 270);
        SeekPosicion<T> escaparAbajo = new SeekPosicion<>(blackboard, new Vector2(Gdx.graphics.getWidth()/2, -500));
        Secuencia<T> escape = new Secuencia<>();
        escape.addPrimeraTarea(mirarAbajo);
        escape.addUltimaTarea(escaparAbajo);

        Paralela<T> atacar = new Paralela<>();
        atacar.addPrimeraTarea(mirarObjetivo);
        atacar.addUltimaTarea(seguirCaminoAleatorio);

        HastaCondicion<T> hastaEscapar = new HastaCondicion<>(blackboard, atacar, condicionEscapeKamikaze, true);

        Selector<T> tareaRaiz = new Selector<>();
        tareaRaiz.addPrimeraTarea(hastaEscapar);
        tareaRaiz.addUltimaTarea(escape);

        return tareaRaiz;
    }

    public boolean realizar(float delta) {
        return enemigoTarea.realizar(delta);
    }

}
