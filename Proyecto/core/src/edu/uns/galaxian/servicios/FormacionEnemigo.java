package edu.uns.galaxian.servicios;

import com.badlogic.gdx.Gdx;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;

import java.util.*;

// TODO Revisitar clase una vez que se unifique el controlador
public class FormacionEnemigo implements Servicio {

    private static final int DISTANCIA = 50;
    private static final int MARGEN_SUPERIOR = 50;
    private static final int LIMITE_ENEMIGOS_ATACANDO = 3;

    private List<List<Enemigo>> enemigos;
    private List<Entidad> enemigosEliminados;
    private Set<Enemigo> enemigosAtacando;
    private Controlador controlador;
    private volatile boolean activado;

    public FormacionEnemigo(List<List<Enemigo>> enemigos, Controlador controlador){
        this.enemigosEliminados = new ArrayList<>();
        this.enemigosAtacando = new HashSet<>();
        this.enemigos = enemigos;
        this.controlador = controlador;
        registrarEnemigos();
        formarEnemigos();
    }

    public void activar() throws IllegalStateException {
        if(activado) throw new IllegalStateException("El servicio no puede activarse si ya esta activo.");
        activado = true;
        new Thread(new RunnableFormacion()).start();
    }

    public void desactivar() throws IllegalStateException{
        if(!activado) throw new IllegalStateException("El servicio no puede desactivarse si no esta activo.");
        activado = false;
    }

    /**
     * Utiliza la lista de listas de enemigos para ubicar a cada
     * uno en la posicion que le corresponde.
     */
    private void formarEnemigos(){
        float referenciaX = Gdx.graphics.getWidth() / 2f;
        float posX;
        float posY;
        int filaNum = 0;
        for(List<Enemigo> fila : enemigos){
            int colNum = 0;
            int puntoMedio = fila.size() / 2;
            posY = MARGEN_SUPERIOR + (filaNum * DISTANCIA);
            for(Enemigo enemigo : fila){
                // TODO Se deberia setear un estado de formacion
                posX = referenciaX + (colNum - puntoMedio) * DISTANCIA;
                enemigo.setPosicion(posX, posY);
            }
        }

    }

    /**
     * Registra a todos los enemigos en el controlador
     */
    private void registrarEnemigos(){
        for(List<Enemigo> fila : enemigos){
            for(final Enemigo enemigo : fila){
                controlador.agregarEntidad(enemigo);
                enemigo.getVida().observar(new Observador<LiveData<Integer>>() {
                    public void notificar(LiveData<Integer> subject) {
                        if(subject.getValor() == 0){
                            subject.removerObservador(this);
                            enemigosEliminados.add(enemigo); // TODO Esto puede explotar si el run esta recorriendo la lista ?
                        }
                    }
                });
            }
        }
    }

    /**
     * Verifica que no haya filas vacias por enemigos
     * que se eliminaron. Si encuentra alguna elimina esta fila.
     */
    private void verificarFilasVacias(){
        for(List<Enemigo> fila : enemigos){
            if(fila.isEmpty()){
                enemigos.remove(fila);
            }
        }
    }

    /**
     * Verifica si alguno de los enemigos de la formacion
     * fue eliminado, y en ese caso lo elimina de la lista de
     * la formacion.
     */
    private void verificarEntidadesEliminadas(){
        if(!enemigosEliminados.isEmpty()){
            for(List<Enemigo> fila : enemigos){
                for(Enemigo enemigo : fila){
                    for(Entidad entidadEliminada : enemigosEliminados){
                        if(enemigo == entidadEliminada){
                            fila.remove(enemigo);
                            enemigosAtacando.remove(enemigo);
                            enemigosEliminados.remove(entidadEliminada);
                        }
                    }
                }
            }
        }
    }

    private class RunnableFormacion implements Runnable{
        public void run(){
            Random random = new Random();
            while(activado && !enemigos.isEmpty()){
                // TODO Se deberia setear un estado de ataque normal
                verificarEntidadesEliminadas();
                verificarFilasVacias();
                if(enemigosAtacando.size() <= LIMITE_ENEMIGOS_ATACANDO){
                    int cantFilas = enemigos.size();
                    List<Enemigo> filaRandom = enemigos.get(random.nextInt(cantFilas));
                    Enemigo enemigoRandom = filaRandom.get(random.nextInt(filaRandom.size()));
                    enemigoRandom.atacar();
                    enemigosAtacando.add(enemigoRandom);
                    try{
                        Thread.sleep(2000 + random.nextInt(3000));
                    }catch (InterruptedException e){
                        System.out.println("Error en ejecucion de Thread de FormacionEnemigo");
                    }
                }
            }
        }
    }
}
