package edu.uns.galaxian.oleada;

import java.util.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.ia.TareaNula;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.temporizador.Temporizador;

public class OleadaBonus implements Oleada {

    private static final int LIMITE_ENEMIGOS_ATACANDO = 3;

    protected List<Enemigo> enemigos;
    private Set<Enemigo> enemigosAtacando;
    private Temporizador temporizador;
    private Controlador controlador;
    private boolean iniciado;
    private Nivel nivel;

    public OleadaBonus(List<Enemigo> enemigos, Controlador controlador, Nivel nivel){
        this.controlador = controlador;
        this.enemigos = enemigos;
        this.nivel = nivel;
        enemigosAtacando = new HashSet<>();
        temporizador = new Temporizador();
        registrarEnemigos(enemigos);
    }

    public void iniciar() throws IllegalStateException {
        if(iniciado) throw new IllegalStateException("La oleada no puede iniciado si ya esta iniciada.");
        iniciado = true;
    }

    public void actualizar(float delta) throws IllegalStateException{
        System.out.println("Enemigos en juego " + enemigos.size());
        System.out.println("Enemigos atacando " + enemigosAtacando.size());
        if(!iniciado) throw new IllegalStateException("La oleada no puede actualizarse si no esta iniciada.");
        verificarEnemigosEnPantalla();
        if(enemigos.isEmpty()){
            nivel.oleadaFinalizada();
        }
        else if(enemigosAtacando.size() <= LIMITE_ENEMIGOS_ATACANDO && temporizador.tiempoCumplido()){
            Random random = new Random();
            int cantNuevosAtacantes = random.nextInt(4);
            for(int i = 0; i < cantNuevosAtacantes; i++){
                Enemigo enemigoRandom = enemigos.get(random.nextInt(enemigos.size()));
                if(!enemigosAtacando.contains(enemigoRandom)) {
	                enemigoRandom.setPosicion(getPosicionAleatoria());
	                controlador.agregarEntidad(enemigoRandom);
	                enemigosAtacando.add(enemigoRandom);
	                temporizador.iniciar(2000 + random.nextInt(3000));
	                enemigoRandom.atacar();
                }
            }
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
    protected void registrarEnemigos(List<Enemigo> enemigos){
        for(final Enemigo enemigo : enemigos){
            enemigo.setPosicion(-500,-500);
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

    /**
     * Elimina un enemigo de la lista de enemigos
     * @param enemigo Enemigo a eliminar
     */
    private void eliminarEnemigo(Enemigo enemigo){
        enemigos.remove(enemigo);
        enemigosAtacando.remove(enemigo);
    }

    /**
     * Verifica que los enemigos que esten atacando
     * sigan dentro de los limites de la pantalla.
     * En caso de que no este dentro, los coloca en la
     * formacion
     */
    private void verificarEnemigosEnPantalla(){
        Iterator<Enemigo> enemigosIt = enemigosAtacando.iterator();
        while(enemigosIt.hasNext()){
            Enemigo enemigo = enemigosIt.next();
            if(enemigo.getPosicion().y < -100){
                enemigo.setTareaInteligencia(new TareaNula<>());
                enemigosIt.remove();
                enemigos.remove(enemigo);
                enemigo.eliminar();
            }
        }
    }
	
    /**
     * Devulve una posicion aleatoria en el extremo superior de la pantalla.
     * @return Vector de posicion aleatoria.
     */
    private Vector2 getPosicionAleatoria() {
    	Random ran = new Random();
    	int anchoPermitido = Gdx.graphics.getWidth()/3;
    	float posX = ran.nextInt(anchoPermitido) + anchoPermitido;
    	float posY = Gdx.graphics.getHeight() + 200;
        return new Vector2(posX,posY);
    }
    
}