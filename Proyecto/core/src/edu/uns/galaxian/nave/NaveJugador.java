package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.util.enums.Color;

public abstract class NaveJugador extends Nave<DisparoJugador> {

    protected Color colorNave;

    public NaveJugador(String texturaDir, Color colorNave){
        super(new ArmaComun<>(new FabricaDisparoJugador()), new EscudoNulo(), texturaDir);
        this.colorNave = colorNave;
    }

    /**
     * Retorna el color de la nave
     * @return Color de la nave
     */
    public Color getColorNave(){
        return colorNave;
    }
}
