package edu.uns.galaxian.servicios;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.autonoma.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.ia.inteligencias.InteligenciaDeDesarrollo;

public class ServicioDeDesarrollo implements Servicio {

    private Controlador controlador;
    private FabricaEnemigos fabrica;

    public ServicioDeDesarrollo(Controlador controlador, FabricaEnemigos fabricaEnemigos){
        this.controlador = controlador;
        this.fabrica = fabricaEnemigos;
    }

    public void activar() throws IllegalStateException {
        Enemigo enemigo = fabrica.getKamikaze(new Vector2(200,700), controlador, controlador.getJugador());
        enemigo.setInteligencia(new InteligenciaDeDesarrollo(enemigo, controlador.getJugador()));
        controlador.agregarEntidad(enemigo);
        Enemigo enemigo1 = fabrica.getKamikaze(new Vector2(1100,700), controlador, controlador.getJugador());
        enemigo1.setInteligencia(new InteligenciaDeDesarrollo(enemigo1, enemigo));
        //controlador.agregarEntidad(enemigo1);
    }

    public void desactivar() throws IllegalStateException {

    }
}
