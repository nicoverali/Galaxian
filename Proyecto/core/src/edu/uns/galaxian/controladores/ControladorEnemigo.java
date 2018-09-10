package edu.uns.galaxian.controladores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnemigo implements ControladorEntidad {

    private static final int TAMANIO_NAVES = 64;

    private List<List<Enemigo>> enemigos;
    private Jugador jugador;

    public ControladorEnemigo(JSONObject config, Jugador jugador){
        this.jugador = jugador;

        // Crear formacion de enemigos
        JSONArray formacion = config.getJSONArray("formacion");
        enemigos = new ArrayList<List<Enemigo>>(formacion.length());
        for(int i = 0; i < formacion.length(); i++){
            JSONArray fila = formacion.getJSONArray(i);
            List<Enemigo> filaLista = new ArrayList<Enemigo>(fila.length());
            for(int j = 0; j < fila.length(); j++){
                // TODO Los enemigos deben depender de la informacion provista, ademas se deben colocar en distintas posiciones
                Enemigo enemigo = new Enemigo();
                filaLista.add(enemigo);
            }
            enemigos.add(filaLista);
        }
    }

    public Vector2 getPosicionJugador(){
        return jugador.getPosicion();
        // TODO Asi se agrega un 
    }

    @Override
    public void actualizarEstado() {
        // TODO Este metodo debe decidir cuando un enemigo sale de la formacion
        for(List<Enemigo> fila : enemigos){
            for(Enemigo enemigo : fila){
                // TODO Se debe actualizar el enemigo
            }
        }
    }

    @Override
    public void dibujar(SpriteBatch batch) {
        for(List<Enemigo> fila : enemigos){
            for(Enemigo enemigo : fila){
                // TODO Se debe dibujar al enemigo {enemigo.dibujar(batch)}
            }
        }
    }
}
