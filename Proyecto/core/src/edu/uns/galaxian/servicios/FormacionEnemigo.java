package edu.uns.galaxian.servicios;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.ia.inteligencias.enemigo.InteligenciaFormacionDinamica;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.enums.TipoEnemigo;

import java.util.*;

public class FormacionEnemigo implements Oleada {

    private static final int DISTANCIA = 35;
    private static final int MARGEN_SUPERIOR = 40;
    private static final int LIMITE_ENEMIGOS_ATACANDO = 3;

    private List<List<Enemigo>> enemigos;
    private List<Enemigo> enemigosEliminados;
    private Map<Enemigo, Vector2> enemigosAtacando;
    private Controlador controlador;
    private volatile boolean iniciado;

    public FormacionEnemigo(List<List<Enemigo>> enemigos, Controlador controlador){
        this.enemigosEliminados = new ArrayList<>();
        this.enemigosAtacando = new HashMap<>();
        this.controlador = controlador;
        this.enemigos = enemigos;
        registrarEnemigos(enemigos);
    }

    public void iniciar() throws IllegalStateException {
        if(iniciado) throw new IllegalStateException("La oleada no puede iniciado si ya esta iniciada.");
        iniciado = true;
        new Thread(new RunnableFormacion()).start();
    }

    public void pausar(){
        if(!iniciado) throw new IllegalStateException("La oleada no puede pausarse si no esta iniciada.");
    }

    public void finalizar() throws IllegalStateException{
        if(!iniciado) throw new IllegalStateException("La oleada no puede finalizar si no esta iniciada.");
        iniciado = false;
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
                            enemigosEliminados.add(enemigo);
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
     * Verifica que no haya filas vacias por enemigos
     * que se eliminaron. Si encuentra alguna elimina esta fila.
     */
    private void verificarFilasVacias(){
        Iterator<List<Enemigo>> ItFila = enemigos.iterator();
        while(ItFila.hasNext()){
            List<Enemigo> fila = ItFila.next();
            if(fila.isEmpty()){
                ItFila.remove();
            }
        }
    }

    /**
     * Verifica si alguno de los enemigos de la formacion
     * fue eliminado, y en ese caso lo elimina de la lista de
     * la formacion.
     */
    private void verificarEntidadesEliminadas(){
        for(Enemigo enemigoEliminado : enemigosEliminados){
            for(List<Enemigo> fila : enemigos){
                fila.remove(enemigoEliminado);
            }
            enemigosAtacando.remove(enemigoEliminado);
        }
        enemigosEliminados.clear();
    }

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

    private class RunnableFormacion implements Runnable{
        public void run(){
            Random random = new Random();
            while(iniciado && !enemigos.isEmpty()){
                // TODO Se deberia setear un estado de ataque normal
                if(enemigosAtacando.size() <= LIMITE_ENEMIGOS_ATACANDO){
                    int cantFilas = enemigos.size();
                    List<Enemigo> filaRandom = enemigos.get(random.nextInt(cantFilas));
                    Enemigo enemigoRandom = filaRandom.get(random.nextInt(filaRandom.size()));
                    enemigoRandom.atacar();
                    enemigosAtacando.put(enemigoRandom, enemigoRandom.getPosicion());
                    try{
                        Thread.sleep(2000 + random.nextInt(3000));
                    }catch (InterruptedException e){
                        System.out.println("Error en ejecucion de Thread de FormacionEnemigo");
                    }
                }
                verificarEntidadesEliminadas();
                verificarFilasVacias();
                verificarEnemigosEnPantalla();
            }
        }
    }
}
