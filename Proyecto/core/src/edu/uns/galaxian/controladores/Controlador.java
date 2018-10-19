package edu.uns.galaxian.controladores;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;

import java.util.*;

public class Controlador {

    private List<Entidad> entidades;
    private Set<Entidad> nuevasEntidades;
    private Set<Entidad> entidadesEliminadas;
    private List<Jugador> jugadores;
    private DetectorColision detectorColision;
    private int puntuacion;
    
    public Controlador(Jugador jugador){
        detectorColision = new DetectorColision();
        entidades = new ArrayList<>();
        nuevasEntidades = new HashSet<>();
        entidadesEliminadas = new HashSet<>();
        jugadores = new ArrayList<>(3);
        puntuacion=0;
        jugadores.add(jugador);
        detectorColision.registrarColisionable(jugador);
    }
    
    public void sumar(int aSumar){
    	puntuacion+=aSumar;
    }
    
    public int getPuntuacion(){
    	return puntuacion;
    }

    /**
     * Registra una nueva entidad en el controlador
     * @param entidad Nueva entidad
     */
    public void agregarEntidad(Entidad entidad){
        nuevasEntidades.add(entidad);
        detectorColision.registrarColisionable(entidad);
    }

    /**
     * Registra una coleccion de nuevas entidades en el controlador.
     * @param entidades Coleccion de nuevas entidades
     */
    public <T extends Entidad> void agregarEntidades(Collection<T> entidades){
        nuevasEntidades.addAll(entidades);
        for(Entidad entidad : entidades){
            detectorColision.registrarColisionable(entidad);
        }
    }

    /**
     * Registra un nuevo jugador en el controlador
     * @param jugador Nuevo jugador
     */
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    /**
     * Si la entidad recibida esta registrada en este controlador
     * entonces es eliminada.
     * @param entidad Entidad a eliminar
     * @throws IllegalArgumentException Si la entidad recibida no esta registrada en este controlador
     */
    public void eliminarEntidad(Entidad entidad) throws IllegalArgumentException{
        if(!entidades.contains(entidad)){
            throw new IllegalArgumentException("La entidad recibida no se encuentra registrada.");
        }
        entidadesEliminadas.add(entidad);
    }

    public void eliminarJugador(Jugador jugador) throws IllegalArgumentException{
        if(!jugadores.contains(jugador)){
            throw new IllegalArgumentException("El jugador recibido no se encuentra registrado.");
        }
        jugadores.remove(jugador);
        detectorColision.eliminarColisionable(jugador);
    }

    /**
     * Retorna una coleccion de todas las entidades registradas en este controlador.
     * @return Coleccion de entidades registradas
     */
    public Collection<Entidad> getEntidades(){
        return copiarLista(entidades);
    }

    /**
     * Retorna una coleccion de todos los jugadores del controlador.
     * @return Coleccion de jugadores registrados
     */
    public Collection<Jugador> getJugadores(){
        return copiarLista(jugadores);
    }

    /**
     * Toma al azar un jugador registrado en el controlador y lo devuelve.
     * @return Jugador registrado al azar
     */
    public Jugador getJugador(){
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));
    }

    /**
     * Actualiza el estado de todas las entidades registradas en este controlador
     * @param delta Tiempo transcurrido desde el ultimo frame
     */
    public void actualizarEstado(float delta){
        detectorColision.resolverColisiones();
        for(Entidad entidad : entidades){
            entidad.actualizar(delta);
        }
        for(Jugador jugador : jugadores){
            jugador.actualizar(delta);
        }
        entidades.addAll(nuevasEntidades);
        entidades.removeAll(entidadesEliminadas);
        for(Entidad eliminada : entidadesEliminadas){
            detectorColision.eliminarColisionable(eliminada);
        }
        nuevasEntidades.clear();
        entidadesEliminadas.clear();
    }

    /**
     * Dibuja utilizando el EntidadBatch recibido a todas las entidades registradas
     * en este controlador.
     * @param batch EntidadBatch utilizado para dibujar las entidades registradas
     */
    public void dibujar(EntidadBatch batch){
        for(Entidad entidad : entidades){
            entidad.dibujar(batch);
        }
        for(Jugador jugador : jugadores){
            jugador.dibujar(batch);
        }
    }

    /**
     * Retorna la copia de una lista
     * @param <T>
     * @param listaOriginal Lista original
     * @return Copia de la lista original
     */
    private <T> List<T> copiarLista(List<T> listaOriginal){
        List<T> listaCopia = new ArrayList<>(listaOriginal.size());
        Collections.copy(listaCopia, listaOriginal);
        return listaCopia;
    }
}
