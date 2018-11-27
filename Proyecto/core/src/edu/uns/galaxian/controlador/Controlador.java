package edu.uns.galaxian.controlador;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import edu.uns.galaxian.colision.Colisionable;
import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.controlador.actualizadores.VisitorJuegoNormal;
import edu.uns.galaxian.controlador.actualizadores.VisitorJuegoPausa;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;

import java.util.*;

public class Controlador {

    private List<Jugador> jugadores;
    private DetectorColision detectorColision;
    private AssetManager assets;
    private Vigilante vigilante;
    private Visitor visitorActual;
    
    private List<Entidad> entidadesActualizadas;
    private Set<Entidad> nuevasEntidades;
    private Set<Entidad> entidadesEliminadas;
    private List<Colisionable> entidadesColisionables;
    private Set<Colisionable> nuevosColisionables;
    private Set<Colisionable> colisionablesEliminados;

    public Controlador(AssetManager assetManager){
        assets = assetManager;
        detectorColision = new DetectorColision();
        entidadesActualizadas = new ArrayList<>();
        nuevasEntidades = new HashSet<>();
        entidadesEliminadas = new HashSet<>();
        entidadesColisionables = new ArrayList<>();
        nuevosColisionables = new HashSet<>();
        colisionablesEliminados = new HashSet<>();
        jugadores = new ArrayList<>(3);
        vigilante = new Vigilante();
        visitorActual = new VisitorJuegoNormal();
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
     * Registra una nueva entidad colisionable en el detector de colisiones.
     * @param entidad Nueva entidad que podra ser colisionable.
     */
    public void agregarColisionable(Colisionable nuevoColisionable){
        nuevosColisionables.add(nuevoColisionable);
    }

    /**
     * Registra un nuevo jugador en el controlador
     * @param jugador Nuevo jugador
     */
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        entidadesColisionables.add(jugador);
    }

    /**
     * Si la entidad recibida esta registrada en este controlador
     * entonces es eliminada.
     * @param entidad Entidad a eliminar
     * @throws IllegalArgumentException Si la entidad recibida no esta registrada en este controlador
     */
    public void eliminarEntidad(Entidad entidad) throws IllegalArgumentException{
        if(!entidadesActualizadas.contains(entidad) && !nuevasEntidades.contains(entidad)){
            throw new IllegalArgumentException("La entidad recibida no se encuentra registrada.");
        }
        entidadesEliminadas.add(entidad);
    }
    
    /**
     * Si la entidad recibida esta registrada en este controlador
     * entonces es eliminada.
     * @param entidad Entidad a eliminar
     * @throws IllegalArgumentException Si la entidad recibida no esta registrada en este controlador
     */
    public void eliminarColisionable(Colisionable colisionable) throws IllegalArgumentException{
        if(!entidadesColisionables.contains(colisionable) && !nuevosColisionables.contains(colisionable)){
            throw new IllegalArgumentException("La entidad recibida no se encuentra registrada.");
        }
        colisionablesEliminados.add(colisionable);
    }

    public void eliminarJugador(Jugador jugador) throws IllegalArgumentException{
        if(!jugadores.contains(jugador)){
            throw new IllegalArgumentException("El jugador recibido no se encuentra registrado.");
        }
        jugadores.remove(jugador);
        eliminarColisionable(jugador);
    }

    /**
     * Retorna una coleccion de todas las entidades registradas en este controlador.
     * @return Coleccion de entidades registradas
     */
    public Collection<Entidad> getEntidades(){
        return copiarLista(entidadesActualizadas);
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

    public TextureAtlas getTextureAtlas(String atlasName){
        return assets.get(atlasName);
    }

    /**
     * Actualiza el estado de todas las entidades registradas en este controlador
     * @param delta Tiempo transcurrido desde el ultimo frame
     */
    public void actualizarEstado(float delta){
    	entidadesColisionables.addAll(nuevosColisionables);
    	entidadesColisionables.removeAll(colisionablesEliminados);
        nuevosColisionables.clear();
        colisionablesEliminados.clear();
        detectorColision.resolverColisiones(entidadesColisionables);
        
        entidadesActualizadas.addAll(nuevasEntidades);
        entidadesActualizadas.removeAll(entidadesEliminadas);
        entidadesColisionables.addAll(nuevasEntidades);
        entidadesColisionables.removeAll(entidadesEliminadas);
        nuevasEntidades.clear();
        entidadesEliminadas.clear();
        
        for(Entidad entidad : entidadesActualizadas){
            entidad.aceptarVisitor(visitorActual);
        }
        
        for(Jugador jugador : jugadores){
            jugador.aceptarVisitor(visitorActual);
        }
    }

    /**
     * Dibuja utilizando el EntidadBatch recibido a todas las entidades registradas
     * en este controlador.
     * @param batch EntidadBatch utilizado para dibujar las entidades registradas
     */
    public void dibujar(EntidadBatch batch){
        for(Entidad entidad : entidadesActualizadas){
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
    
    public void setActualizacion(Visitor nuevoVisitor, Caller caller) {
    	Memento estadoActual = new Memento(caller);
    	vigilante.guardarMemento(estadoActual);
    	visitorActual = nuevoVisitor;
    }
    
    public void restaurar(Caller caller) {
    	if(vigilante.getUltimoMemento().getCaller()==caller) {
    		visitorActual = vigilante.getVisitorRestaurado();
    	}
    }
    
    public void pausar() {
    	Memento estadoActual = new Memento(visitorActual);
    	vigilante.guardarMemento(estadoActual);
    	visitorActual = new VisitorJuegoPausa();
    }
    
    public void reanudar() {
    	visitorActual = vigilante.getUltimoMemento().getVisitor();
    }

}