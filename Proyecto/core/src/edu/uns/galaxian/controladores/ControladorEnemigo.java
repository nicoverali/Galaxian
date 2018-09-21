package edu.uns.galaxian.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.autonoma.FabricaEnemigos;
import edu.uns.galaxian.entidades.autonoma.FabricaEstandar;
import edu.uns.galaxian.entidades.jugador.Jugador;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControladorEnemigo implements ControladorEntidad {

    private static final int TAMANIO_NAVES = 40;

    private List<List<Enemigo>> enemigos;
    private List<Enemigo> listaEliminar;
    private Jugador jugador;
    private DetectorColision detector;

    public ControladorEnemigo(JSONObject config, Jugador jugador, DetectorColision detector){
    	this.detector = detector;
        this.jugador = jugador;
        this.detector = detector;
        listaEliminar = new LinkedList<Enemigo>();
        
        // TODO Por ahora el controladorEnemigo creara la fabrica de enemigos, mas adelante veremos que el nivel sea quien la cree
        FabricaEnemigos fabrica = new FabricaEstandar();

        // Crear formacion de enemigos
        JSONArray formacion = config.getJSONArray("formacion");
        enemigos = new ArrayList<>(formacion.length());
        for(int i = 0; i < formacion.length(); i++) {
            JSONArray fila = formacion.getJSONArray(i);
            List<Enemigo> filaLista = new ArrayList<Enemigo>(fila.length());
            for(int j = 0; j < fila.length(); j++){
                // TODO Los enemigos deben depender de la informacion provista, ademas se deben colocar en distintas posiciones
                Enemigo enemigo = fabrica.getEnemigoComun(getPosX(fila.length(),j),getPosY(i));
                enemigo.setControladorEnemigo(this);
                // TODO setear la IA al enemigo
                detector.registrarColisionable(enemigo);
                filaLista.add(enemigo);
            }
            enemigos.add(filaLista);
        }
    }

    private int getPosX(int cantidadNaves, int j) {
    	int mitadPantalla = Gdx.graphics.getWidth() / 2;
    	int margen = 25;
    	int resultado = 0;
    	int espacioOcupado;
    	int espacioSobrante;

    	if(cantidadNaves%2==0) {
    		espacioOcupado = (cantidadNaves/2 * TAMANIO_NAVES) + (cantidadNaves/2 * margen);
    	}
    	else {
    		espacioOcupado = (cantidadNaves/2 * TAMANIO_NAVES) + (cantidadNaves/2 * margen + TAMANIO_NAVES/2);
    	}

    	espacioSobrante = mitadPantalla - espacioOcupado;
    	int aux = 0;
		for(int i=0; i<=j; i++) {
			aux += TAMANIO_NAVES + margen;
		}
		resultado = aux - margen - (TAMANIO_NAVES/2) + espacioSobrante;

    	return resultado;
    }

    private int getPosY(int numeroFila) {
    	int margen = 10;
    	return Gdx.graphics.getHeight() - (numeroFila+1)*TAMANIO_NAVES - margen;
    }

    public Vector2 getPosicionJugador(){
        return jugador.getPosicion();
    }

    @Override
    public void actualizarEstado() {
        // TODO Este metodo debe decidir cuando un enemigo sale de la formacion
    	for(int fila=0; fila<enemigos.size(); fila++) {
    		List<Enemigo> aux = enemigos.get(fila);
    		for(int enemigo=0; enemigo<aux.size(); enemigo++) {
    			Enemigo e = aux.get(enemigo);
                // TODO Se debe actualizar el enemigo
                detector.verificarYResolverColisiones(e);
            }
    	}
    	
    	for(Enemigo eliminado : listaEliminar) {
    		boolean encontre = false;
    		for(int i=0; i<enemigos.size() && !encontre; i++) {
    			List<Enemigo> fila = enemigos.get(i);
    			for(int j=0; j<fila.size() && !encontre ;j++) {
    				if(fila.get(j)==eliminado) {
    					encontre = true;
    					fila.remove(eliminado);
    					detector.eliminarEntidad(eliminado);
    				}
    			}
    		}
		}
    	listaEliminar = new LinkedList<Enemigo>();
    }
    
    public void setDetectorColisiones(DetectorColision d) {
    	detector = d;
    }

    public void dibujar(SpriteBatch batch) {
        for(List<Enemigo> fila : enemigos){
            for(Enemigo enemigo : fila){
                enemigo.dibujar(batch);
            }
        }
    }
	
	public void deregistrar(Enemigo enemy) {
		listaEliminar.add(enemy);
	}
}
