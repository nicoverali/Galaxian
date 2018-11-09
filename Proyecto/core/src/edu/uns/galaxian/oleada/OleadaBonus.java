package edu.uns.galaxian.oleada;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.inteligencias.basica.InteligenciaNula;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.temporizador.Temporizador;

public class OleadaBonus implements Oleada {

    private static final int LIMITE_ENEMIGOS_ATACANDO = 4;

    private List<List<Enemigo>> enemigos;
    private Map<Enemigo, Vector2> enemigosAtacando;
    private Temporizador temporizador;
    private Controlador controlador;
    private boolean iniciado;
    private Nivel nivel;

    public OleadaBonus(List<List<Enemigo>> enemigos, Controlador controlador, Nivel nivel){
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
            enemigoRandom.setPosicion(getPosicionAleatoria());
            controlador.agregarEntidad(enemigoRandom);
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
     * Registra a todos los enemigos sin ponerlos en el controlador.
     */
    private void registrarEnemigos(List<List<Enemigo>> enemigos){
        for(int i = 0; i < enemigos.size(); i++){
            List<Enemigo> fila = enemigos.get(i);
            for(int j = 0; j < fila.size(); j++){
                final Enemigo enemigo = fila.get(j);
                enemigo.setPosicion(0,0);
                enemigo.setInteligencia(new InteligenciaNula<Enemigo>(enemigo));
                enemigo.getVida().observar(new Observador<LiveData<Integer>>() {
                    public void notificar(LiveData<Integer> subject) {
                        if(subject.getValor() == 0){
                            subject.removerObservador(this);
                            eliminarEnemigo(enemigo);
                        }
                    }
                });
            }
        }
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
                enemigosAtacando.remove(enemigo);
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
                enemigo.transicionarInteligencia(new InteligenciaNula<Enemigo>(enemigo));
                enemigosIt.remove();
                controlador.eliminarEntidad(enemigo);
            }
        }
    }
	
    /**
     * Devulve una posicion aleatoria en el extremo superior de la pantalla.
     * @return Vector de posicion aleatoria.
     */
    private Vector2 getPosicionAleatoria() {
    	Random ran = new Random();
    	int ANCHO_PANTALLA = Gdx.graphics.getWidth();
    	float posX = ran.nextInt(ANCHO_PANTALLA);
    	float posY = Gdx.graphics.getHeight();
    	Vector2 pos = new Vector2(posX,posY);
    	return pos;
    }
    
}