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
import edu.uns.galaxian.ia.tareas.condiciones.CondicionVida;
import edu.uns.galaxian.ia.tareas.decorators.HastaCondicion;
import edu.uns.galaxian.util.camino.simple.CaminoAleatorio;
import edu.uns.galaxian.util.enums.Comparacion;
import edu.uns.galaxian.util.enums.Direccion;

public class InteligenciaKamikazeMixto<T extends Enemigo> extends Tarea<T> {

    private Tarea<T> enemigoTarea;

    public InteligenciaKamikazeMixto(Blackboard<T> blackboard) {
        super(blackboard);
        enemigoTarea = construirInteligencia();
    }

    private Tarea<T> construirInteligencia(){
        T enemigo = blackboard.getAutonomo();

        // Caminos
        CaminoAleatorio caminoAleatorio = new CaminoAleatorio(enemigo.getPosicion(), Direccion.ABAJO, Gdx.graphics.getWidth()-500, 200, 50, true, 3);
        PathFollowSimple seguirCaminoAleatorio = new PathFollowSimple<>(blackboard, caminoAleatorio, 1);

        // Siempre mirar al objetivo
        MirarA<T> mirarObjetivo = new MirarA<>(blackboard);

        // Perseguir al objetivo
        Perseguir<T> perseguirObjetivo = new Perseguir<>(blackboard);

        // SI la vida es menos de 50 debe ser aleatorio
        CondicionVida<T> tieneMasDe50 = new CondicionVida<>(blackboard, 50, Comparacion.MAYORIGUAL);
        HastaCondicion<T> hasta50Vida = new HastaCondicion<>(blackboard, perseguirObjetivo, tieneMasDe50, false);

        // Escape
        AlinearRotacion<T> mirarAbajo = new AlinearRotacion<>(blackboard, 270);
        SeekPosicion<T> escaparAbajo = new SeekPosicion<>(blackboard, new Vector2(Gdx.graphics.getWidth()/2, -500));
        Secuencia<T> escape = new Secuencia<>();
        escape.addPrimeraTarea(mirarAbajo);
        escape.addUltimaTarea(escaparAbajo);

        Selector<T> atacar = new Selector<>();
        atacar.addPrimeraTarea(hasta50Vida);
        atacar.addUltimaTarea(seguirCaminoAleatorio);

        Secuencia<T> continuamente = new Secuencia<>();
        continuamente.addPrimeraTarea(mirarObjetivo);
        continuamente.addUltimaTarea(atacar);

        CondicionEscapeKamikaze<T> condicionEscapeKamikaze = new CondicionEscapeKamikaze<>(blackboard);
        HastaCondicion<T> continuamenteHastaEscape = new HastaCondicion<>(blackboard, continuamente, condicionEscapeKamikaze, true);

        Selector<T> tareaRaiz = new Selector<>();
        tareaRaiz.addPrimeraTarea(continuamenteHastaEscape);
        tareaRaiz.addUltimaTarea(escape);

        return tareaRaiz;
    }

    public boolean realizar(float delta) {
        return enemigoTarea.realizar(delta);
    }

}