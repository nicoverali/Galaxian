package edu.uns.galaxian.nave;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoEnemigo;

public abstract class NaveEnemigo extends Nave<DisparoEnemigo> {

    private int vidaMaxima;
    private float velocidadMax;
    private float steeringMax;
    private int fuerzaColision;

    public NaveEnemigo(String texturaDir, int vidaMaxima, float velocidadMax, int fuerzaColision, float steeringMax){
        super(new ArmaComun<>(new FabricaDisparoEnemigo()), texturaDir);
        this.vidaMaxima = vidaMaxima;
        this.velocidadMax = velocidadMax;
        this.steeringMax = steeringMax;
        this.fuerzaColision = fuerzaColision;
    }

    /**
     * Retorna la inteligencia de ataque de la nave
     * @return Inteligencia de ataque
     */
    public abstract InteligenciaArtificial getInteligenciaAtaque();

    /**
     * La nave acepta entrar en un estado de colision. Recibe
     * el colisionador del un colisionable para indicarle que accion realizar.
     * @param colisionador Colisionador de un colisionable participante en la colision producida
     */
    public abstract void aceptarColision(Colisionador colisionador);

    /**
     * Retorna la fuerza con la que colisiona la nave
     * @return Fuerza con que colisiona la nave
     */
    public int getFuerzaDeColision(){
        return fuerzaColision;
    }

    /**
     * Retorna la capacidad de steering maxima de la nave
     * @return Capacidad de steering
     */
    public float getSteeringMax(){
        return steeringMax;
    }

    public int getVidaMax() {
        return vidaMaxima;
    }

    public float getVelocidadMax() {
        return velocidadMax;
    }
}
