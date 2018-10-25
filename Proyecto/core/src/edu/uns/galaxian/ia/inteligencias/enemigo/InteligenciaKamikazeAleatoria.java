package edu.uns.galaxian.ia.inteligencias.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.btree.Tarea;
import edu.uns.galaxian.ia.btree.acciones.MirarA;
import edu.uns.galaxian.ia.btree.acciones.PathFollowSimple;
import edu.uns.galaxian.ia.btree.acciones.Perseguir;
import edu.uns.galaxian.ia.btree.acciones.Seek;
import edu.uns.galaxian.ia.btree.composiciones.Paralela;
import edu.uns.galaxian.ia.btree.composiciones.Selector;
import edu.uns.galaxian.ia.btree.condiciones.CondicionPosicion;
import edu.uns.galaxian.ia.btree.decorators.HastaCondicion;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.util.camino.simple.CaminoAleatorio;
import edu.uns.galaxian.util.camino.simple.CaminoCircular;
import edu.uns.galaxian.util.enums.Comparacion;
import edu.uns.galaxian.util.enums.Componente;
import edu.uns.galaxian.util.enums.Direccion;

import java.util.Arrays;

public class InteligenciaKamikazeAleatoria<T extends Enemigo> implements InteligenciaArtificial<T> {

    private T enemigo;
    private Blackboard<T> blackboard;
    private Tarea<T> enemigoTarea;

    public InteligenciaKamikazeAleatoria(T enemigo, GameObject jugador){
        this.enemigo = enemigo;
        blackboard = new Blackboard<>(enemigo, jugador);
        enemigoTarea = construirInteligencia(jugador);
    }

    private Tarea<T> construirInteligencia(GameObject jugador){
        // Caminos
        CaminoAleatorio caminoAleatorio = new CaminoAleatorio(enemigo.getPosicion(), Direccion.ABAJO, Gdx.graphics.getWidth()-200, 800, 150, false, 5);

        // Siempre mirar al objetivo
        MirarA<T> mirarObjetivo = new MirarA<>(blackboard);

        // Si esta en la linea del objetivo, escapar hacia abajo, dejar de mirar
        CondicionPosicion<T> mientrasNoSePasaDeObjetivo = new CondicionPosicion<>(blackboard, Componente.Y, Comparacion.MAYOR, jugador.getPosicion().y);

        // Seek hacia abajo de la pantalla para escapar
        Seek<T> haciaAbajoDeLaPantalla = new Seek<>(blackboard, new Vector2(Gdx.graphics.getWidth()/2, -200));

        PathFollowSimple followAleatorio = new PathFollowSimple<>(blackboard, caminoAleatorio, 1);
        Paralela<T> mirarYRealizaMovimientos = new Paralela<>(Arrays.asList(mirarObjetivo, followAleatorio));
        HastaCondicion<T> mientrasCumpleCondicion = new HastaCondicion<>(mirarYRealizaMovimientos, mientrasNoSePasaDeObjetivo, false);
        Selector<T> selectorFinal = new Selector<>(Arrays.<Tarea>asList(mientrasCumpleCondicion, haciaAbajoDeLaPantalla));
        return selectorFinal;
    }

    public void pensar(float delta) {
        enemigoTarea.realizar(delta);
    }

    public void transicionar(InteligenciaArtificial<T> nuevaInteligencia) {
        enemigo.setInteligencia(nuevaInteligencia);
    }

}
