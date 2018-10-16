package edu.uns.galaxian.servicios;

import com.badlogic.gdx.Gdx;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;

import java.util.*;

public class FormacionEnemigo implements Servicio, Runnable {

    private static final int DISTANCIA = 50;
    private static final int MARGEN_SUPERIOR = 50;
    private static final int LIMITE_ENEMIGOS_ATACANDO = 3;

    private List<List<Enemigo>> enemigos;
    private Set<Enemigo> enemigosAtacando;
    private List<Entidad> entidadesEliminadas;
    private Controlador controlador;
    private Random random;
    private volatile boolean activado;

    public FormacionEnemigo(List<List<Enemigo>> enemigos, Controlador controlador){
        this.random = new Random();
        this.entidadesEliminadas = new ArrayList<>();
        this.enemigosAtacando = new HashSet<>();
        this.enemigos = enemigos;
        this.controlador = controlador;
        registrarEnemigos();
        formarEnemigos();
    }

    public void activar() throws IllegalStateException {
        if(activado) throw new IllegalStateException("El servicio no puede activarse si ya esta activo.");
        activado = true;
        new Thread(this).start();
    }

    public void desactivar() throws IllegalStateException{
        if(!activado) throw new IllegalStateException("El servicio no puede desactivarse si no esta activo.");
        activado = false;
    }

    public void run(){
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
            for(Enemigo enemigo : fila){
                controlador.agregarEntidad(enemigo);
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
        if(!entidadesEliminadas.isEmpty()){
            for(List<Enemigo> fila : enemigos){
                for(Enemigo enemigo : fila){
                    for(Entidad entidadEliminada : entidadesEliminadas){
                        if(enemigo == entidadEliminada){
                            fila.remove(enemigo);
                            enemigosAtacando.remove(enemigo);
                            entidadesEliminadas.remove(entidadEliminada);
                        }
                    }
                }
            }
        }
    }


}
