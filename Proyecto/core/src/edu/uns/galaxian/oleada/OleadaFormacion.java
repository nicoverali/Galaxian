package edu.uns.galaxian.oleada;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaFormacionDinamica;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.Temporizador;

import java.util.*;

public class OleadaFormacion implements Oleada {

    private static final int DISTANCIA = 35;
    private static final int MARGEN_SUPERIOR = 40;
    private static final int LIMITE_ENEMIGOS_ATACANDO = 3;

    private List<List<Enemigo>> enemigos;
    private Map<Enemigo, Vector2> enemigosAtacando;
    private Temporizador temporizador;
    private Controlador controlador;
    private boolean iniciado;
    private Nivel nivel;

    public OleadaFormacion(List<List<Enemigo>> enemigos, Controlador controlador, Nivel nivel){
        this.controlador = controlador;
        this.enemigos = enemigos;
        this.nivel = nivel;
        enemigosAtacando = new HashMap<>();
        temporizador = new Temporizador();
        registrarEnemigos(enemigos);
    }

    public void iniciar() throws IllegalStateException {
        if(iniciado) throw new IllegalStateException("La oleada no puede iniciado si ya esta iniciada.");
        iniciado = true;
    }

    public void actualizar(float delta) throws IllegalStateException{
        if(!iniciado) throw new IllegalStateException("La oleada no puede actualizarse si no esta iniciada.");
        verificarEnemigosEnPantalla();
        if(enemigos.isEmpty()){
            nivel.oleadaFinalizada();
        }
        else if(enemigosAtacando.size() <= LIMITE_ENEMIGOS_ATACANDO && temporizador.tiempoCumplido()){
            Random random = new Random();
            int cantFilas = enemigos.size();
            List<Enemigo> filaRandom = enemigos.get(random.nextInt(cantFilas));
            Enemigo enemigoRandom = filaRandom.get(random.nextInt(filaRandom.size()));
            enemigoRandom.atacar();
            enemigosAtacando.put(enemigoRandom, enemigoRandom.getPosicion());
            temporizador.iniciar(2000 + random.nextInt(3000));
        }
    }

    public void finalizar() throws IllegalStateException{
        if(!iniciado) throw new IllegalStateException("La oleada no puede finalizar si no esta iniciada.");
        iniciado = false;
        enemigos.clear();
    }

    /**
     * Registra a todos los enemigos en el controlador
     */
    private void registrarEnemigos(List<List<Enemigo>> enemigos){
        for(int i = 0; i < enemigos.size(); i++){
            List<Enemigo> fila = enemigos.get(i);
            int cantEnFila = fila.size();
            for(int j = 0; j < fila.size(); j++){
                final Enemigo enemigo = fila.get(j);
                Vector2 posicionFormacion = formarEnemigo(i, j, cantEnFila);
                enemigo.setPosicion(posicionFormacion);
                enemigo.setInteligencia(new InteligenciaFormacionDinamica<>(enemigo, posicionFormacion));
                enemigo.getVida().observar(new Observador<LiveData<Integer>>() {
                    public void notificar(LiveData<Integer> subject) {
                        if(subject.getValor() == 0){
                            subject.removerObservador(this);
                            eliminarEnemigo(enemigo);
                        }
                    }
                });
                controlador.agregarEntidad(enemigo);
            }
        }
    }

    /**
     * Devuelve la posicion que le corresponde al enemigo
     * ubicado en la fila y columna recibida.
     * @param fila Numero de fila del enemigo
     * @param columna Numero de columna del enemigo
     * @param cantEnFila Cantidad de enemigos en la fila
     * @return Posicion en pantalla que le corresponde al enemigo
     */
    private Vector2 formarEnemigo(int fila, int columna, int cantEnFila){
        float medioPantalla = Gdx.graphics.getWidth() / 2f;
        float altoPantalla = Gdx.graphics.getHeight();
        float posY = altoPantalla - MARGEN_SUPERIOR - (fila * DISTANCIA);
        float posX = medioPantalla + (columna - (cantEnFila/2)) * DISTANCIA;
        return new Vector2(posX, posY);
    }

    /**
     * Elimina un enemigo de la lista de enemigos
     * @param enemigo Enemigo a eliminar
     */
    private void eliminarEnemigo(Enemigo enemigo){
        Iterator<List<Enemigo>> filasIt = enemigos.iterator();
        while(filasIt.hasNext()){
            List<Enemigo> fila = filasIt.next();
            if(fila.contains(enemigo)){
                fila.remove(enemigo);
                if(fila.isEmpty()){
                    filasIt.remove();
                }
                break;
            }
        }
    }

    /**
     * Verifica que los enemigos que esten atacando
     * sigan dentro de los limites de la pantalla.
     * En caso de que no este dentro, los coloca en la
     * formacion
     */
    private void verificarEnemigosEnPantalla(){
        Iterator<Enemigo> enemigosIt = enemigosAtacando.keySet().iterator();
        while(enemigosIt.hasNext()){
            Enemigo enemigo = enemigosIt.next();
            if(enemigo.getPosicion().y < 0){
                enemigo.setPosicion(enemigo.getPosicion().x, Gdx.graphics.getHeight()+50);
                enemigo.transicionarInteligencia(new InteligenciaFormacionDinamica<>(enemigo, enemigosAtacando.get(enemigo)));
                enemigosIt.remove();
            }
        }
    }
}
