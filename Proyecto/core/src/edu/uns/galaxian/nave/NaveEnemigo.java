package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoEnemigo;
import edu.uns.galaxian.ia.Tarea;

public abstract class NaveEnemigo extends Nave<DisparoEnemigo> {

    private int vidaMaxima;
    private float velocidadMax;
    private float steeringMax;
    private int fuerzaColision;
    private int bonus;

    public NaveEnemigo(String texturaDir, int vidaMaxima, float velocidadMax, int fuerzaColision, int bonus, float steeringMax){
        super(new ArmaComun<>(new FabricaDisparoEnemigo()), texturaDir);
        this.vidaMaxima = vidaMaxima;
        this.velocidadMax = velocidadMax;
        this.steeringMax = steeringMax;
        this.fuerzaColision = fuerzaColision;
        this.bonus = bonus;
    }

    /**
     * Retorna la inteligencia de ataque de la nave
     * @return Inteligencia de ataque
     */
    public abstract Tarea<Enemigo> getTareaAtaque(Enemigo enemigo, Jugador jugador);

    /**
     * Retorna la fuerza con la que colisiona la nave
     * @return Fuerza con que colisiona la nave
     */
    public int getFuerzaDeColision(){
        return fuerzaColision;
    }

    /**
     * Retorna la capacidad de utils maxima de la nave
     * @return Capacidad de utils
     */
    public float getSteeringMax(){
        return steeringMax;
    }

    /**
     * Retorna el el puntaje bonus que consede eliminar
     * a esta nave enemiga.
     * @return Puntaje bonus por eliminar a la nave
     */
    public int getBonus() {
        return bonus;
    }

    public int getVidaMax() {
        return vidaMaxima;
    }

    public float getVelocidadMax() {
        return velocidadMax;
    }

}