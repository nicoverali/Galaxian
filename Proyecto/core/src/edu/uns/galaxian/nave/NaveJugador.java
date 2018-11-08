package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.util.enums.Color;

public abstract class NaveJugador extends Nave<DisparoJugador> {

    protected Color colorNave;

    public NaveJugador(String texturaDir, Color colorNave){
        // TODO Revisar el null
        super(new ArmaComun<>(new FabricaDisparoJugador(null)), texturaDir);
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
