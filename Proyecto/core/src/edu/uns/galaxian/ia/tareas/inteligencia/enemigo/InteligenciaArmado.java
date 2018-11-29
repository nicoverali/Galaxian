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
import edu.uns.galaxian.ia.tareas.condiciones.CondicionEscapeArmado;
import edu.uns.galaxian.ia.tareas.decorators.HastaCondicion;
import edu.uns.galaxian.util.camino.simple.CaminoAleatorio;
import edu.uns.galaxian.util.enums.Direccion;

public class InteligenciaArmado<T extends Enemigo> extends Tarea<T> {

    private Tarea<T> enemigoTarea;

    public InteligenciaArmado(Blackboard<T> blackboard){
        super(blackboard);
        enemigoTarea = construirInteligencia();
    }
    private Tarea<T> construirInteligencia(){
        Enemigo enemigo = blackboard.getAutonomo();

        // Caminos
        CaminoAleatorio caminoAleatorio = new CaminoAleatorio(enemigo.getPosicion(), Direccion.ABAJO, Gdx.graphics.getWidth()-500, 200, 50, true, 10);

        // Disparar al objetivo
        Disparar<T> disparar = new Disparar<>(blackboard, 2);

        // Siempre mirar al objetivo
        MirarA<T> mirarObjetivo = new MirarA<>(blackboard);

        // Seguir el camino
        PathFollowSimple seguirCamino = new PathFollowSimple<>(blackboard, caminoAleatorio, 1);

        // Perseguir al objetivo luego de los caminos
        Perseguir<T> perseguirObjetivo = new Perseguir<>(blackboard);

        // Perseguir hasta estar cerca
        CondicionEscapeArmado<T> condicionEscape = new CondicionEscapeArmado<>(blackboard);
        HastaCondicion<T> mientrasNoEscape;


        // Seek hacia abajo de la pantalla para escapar
        AlinearRotacion<T> mirarAbajo = new AlinearRotacion<>(blackboard, 270);
        SeekPosicion<T> escaparAbajo = new SeekPosicion<>(blackboard, new Vector2(Gdx.graphics.getWidth()/2, -500));
        Secuencia<T> escape = new Secuencia<>();
        escape.addPrimeraTarea(mirarAbajo);
        escape.addUltimaTarea(escaparAbajo);

        Selector<T> movimientos = new Selector<>();
        movimientos.addPrimeraTarea(seguirCamino);
        movimientos.addUltimaTarea(perseguirObjetivo);

        Paralela<T> continuamente = new Paralela<>();
        continuamente.addPrimeraTarea(mirarObjetivo);
        continuamente.addUltimaTarea(disparar);
        continuamente.addUltimaTarea(perseguirObjetivo);
        mientrasNoEscape = new HastaCondicion<>(continuamente, condicionEscape, true);

        Selector<T> tareaRaiz = new Selector<>();
        tareaRaiz.addPrimeraTarea(mientrasNoEscape);
        tareaRaiz.addUltimaTarea(escape);
        return tareaRaiz;
    }

    public boolean realizar(float delta) {
        return enemigoTarea.realizar(delta);
    }
}