package edu.uns.galaxian.nave.jugador;

import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.equipamiento.escudos.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.nave.Nave;

public abstract class NaveJugador extends Nave {

    protected Escudo escudo;

    public NaveJugador(){
        arma = new ArmaComun<DisparoJugador>(new DisparoJugador());
        escudo = new EscudoNulo();
    }

    /**
     * Retorna el escudo de la nave.
     * @return Escudo de la nave
     */
    public Escudo getEscudo(){
        return escudo;
    }

    /**
     * Reemplaza el escudo actual de la nave por uno nuevo.
     * @param nuevoEscudo Nuevo escudo de la nave
     */
    public void setEscudo(Escudo nuevoEscudo){
        escudo = nuevoEscudo;
    }
}
