package edu.uns.galaxian.controlador;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;

import java.util.*;

public class Controlador {

    private List<Entidad> entidades;
    private Set<Entidad> nuevasEntidades;
    private Set<Entidad> entidadesEliminadas;
    private List<Jugador> jugadores;
    private DetectorColision detectorColision;
    private TextureAtlas textureAtlas;
    private int puntuacion;

    public Controlador(TextureAtlas atlas){
        textureAtlas = atlas;
        detectorColision = new DetectorColision();
        entidades = new ArrayList<>();
        nuevasEntidades = new HashSet<>();
        entidadesEliminadas = new HashSet<>();
        jugadores = new ArrayList<>(3);
    }
    
    /**
     * Suma a la puntuacion el valor a sumar
     * @param aSumar valor a sumar
     */
    public void sumar(int aSumar){
    	puntuacion+=aSumar;
    }
    
    /**
     * Retorna la puntuacion
     * @return puntuacion
     */
    public int getPuntuacion(){
    	return puntuacion;
    }
    
   
    /**
     * Registra una nueva entidad en el controlador
     * @param entidad Nueva entidad
     */
    public void agregarEntidad(Entidad entidad){
        nuevasEntidades.add(entidad);
    }

    /**
     * Registra una coleccion de nuevas entidades en el controlador.
     * @param entidades Coleccion de nuevas entidades
     */
    public <T extends Entidad> void agregarEntidades(Collection<T> entidades){
        nuevasEntidades.addAll(entidades);
    }

    /**
     * Registra un nuevo jugador en el controlador
     * @param jugador Nuevo jugador
     */
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        detectorColision.registrarColisionable(jugador);
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
     * @throws IllegalStateException Si no se registraron jugadores en el controlador
     */
    public Collection<Jugador> getJugadores() throws IllegalStateException{
        if(jugadores.isEmpty()) throw new IllegalStateException("Primero se debe agregar al menos un jugador al controlador.");
        return copiarLista(jugadores);
    }

    /**
     * Toma al azar un jugador registrado en el controlador y lo devuelve.
     * @return Jugador registrado al azar
     * @throws IllegalStateException Si no se registro ningun jugador en el controlador
     */
    public Jugador getJugador() throws IllegalStateException{
        if(jugadores.isEmpty()) throw new IllegalStateException("Primero se debe agregar al menos un jugador al controlador.");
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));
    }

    public TextureAtlas getTextureAtlas(){
        return textureAtlas;
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
        for(Entidad nuevaEntidad : nuevasEntidades){
            detectorColision.registrarColisionable(nuevaEntidad);
        }
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
     * @param listaOriginal Lista original
     * @return Copia de la lista original
     */
    private <T> List<T> copiarLista(List<T> listaOriginal){
        List<T> listaCopia = new ArrayList<>(listaOriginal.size());
        Collections.copy(listaCopia, listaOriginal);
        return listaCopia;
    }
}
