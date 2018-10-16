package edu.uns.galaxian.controladores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.Entidad;

import java.util.*;

public class Controlador {

    private List<Entidad> entidades;
    private DetectorColision detectorColision;

    public Controlador(){
        detectorColision = new DetectorColision();
        entidades = new ArrayList<>();
    }

    /**
     * Registra una nueva entidad en el controlador
     * @param entidad Nueva entidad
     */
    public void agregarEntidad(Entidad entidad){
        entidades.add(entidad);
        detectorColision.registrarColisionable(entidad);
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
        entidades.remove(entidad);
        detectorColision.eliminarColisionable(entidad);
    }

    /**
     * Retorna una coleccion de todas las entidades registradas en este controlador.
     * @return Coleccion de entidades registradas
     */
    public Collection<Entidad> obtenerEntidades(){
        List<Entidad> listaCopia = new ArrayList<>();
        Collections.copy(listaCopia, entidades);
        return listaCopia;
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
    }

    /**
     * Dibuja utilizando el SpriteBatch recibido a todas las entidades registradas
     * en este controlador.
     * @param batch SpriteBatch utilizado para dibujar las entidades registradas
     */
    public void dibujar(SpriteBatch batch){
        for(Entidad entidad : entidades){
            entidad.dibujar(batch);
        }
    }
}
