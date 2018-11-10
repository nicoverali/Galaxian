package edu.uns.galaxian.juego.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Asteroide;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp.FabricaPowerUpConvencional;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.tareas.acciones.*;
import edu.uns.galaxian.ia.tareas.composiciones.Secuencia;
import edu.uns.galaxian.ia.tareas.composiciones.Selector;
import edu.uns.galaxian.ia.tareas.condiciones.CondicionEscapeKamikaze;
import edu.uns.galaxian.ia.tareas.condiciones.CondicionPosicion;
import edu.uns.galaxian.ia.tareas.decorators.HastaCondicion;
import edu.uns.galaxian.juego.GameObject;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.nave.enemigo.NaveArmado;
import edu.uns.galaxian.nave.jugador.NaveLiviana;
import edu.uns.galaxian.util.enums.Color;
import edu.uns.galaxian.util.enums.Comparacion;
import edu.uns.galaxian.util.enums.Componente;

public class NivelDesarrollo extends ScreenAdapter {

    private Juego juego;
    private Enemigo enemigo;
    private Jugador obstaculo;
    private Obstaculo obstaculo2;
    private Controlador controlador;

    public NivelDesarrollo(Juego juego) {
        this.juego = juego;
        controlador = new Controlador(juego.getAssetManager());
        enemigo = new Enemigo(new Vector2(400, 400), new NaveArmado(50,400, 15, 1), controlador, new FabricaPowerUpConvencional());
        controlador.agregarEntidad(enemigo);
        obstaculo = new Jugador(new Vector2(Gdx.graphics.getWidth()/2, 50), new NaveLiviana(Color.VERDE), null, controlador);
        obstaculo2 = new Asteroide(0,0, controlador);
        controlador.agregarEntidad(obstaculo);
        enemigo.setTareaInteligencia(crearTarea(enemigo, obstaculo));
    }

    public void render(float delta) {
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0.04f, 0.10f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float posY = Gdx.graphics.getHeight() - Gdx.input.getY();
        Vector2 posicionAnterior = obstaculo.getPosicion();
        //obstaculo.setVelocidad(obstaculo.getPosicion().sub(posicionAnterior));
        controlador.actualizarEstado(delta);
        juego.getBatch().begin();
        controlador.dibujar(juego.getBatch());
        juego.getBatch().end();

        if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
           obstaculo2.setPosicion(Gdx.input.getX(), posY);
        }

    }

    private Tarea<Enemigo> crearTarea(Enemigo enemigo, GameObject objetivo){
        Blackboard<Enemigo> bb = new Blackboard<>(enemigo, obstaculo2);
        CondicionEscapeKamikaze<Enemigo> condicionKamikaze = new CondicionEscapeKamikaze<>(bb);
        CondicionPosicion<Enemigo> pasoLaPantalla = new CondicionPosicion<>(bb, Componente.Y, Comparacion.MENOR, -10);
        Perseguir<Enemigo> perseguirObjetivo = new Perseguir<>(bb);
        SeekPosicion<Enemigo> escaparAbajo = new SeekPosicion<>(bb, new Vector2(Gdx.graphics.getWidth()/2, -500));
        HastaCondicion<Enemigo> hastaCondicionKamikaze = new HastaCondicion<>(bb, perseguirObjetivo, condicionKamikaze, true);
        HastaCondicion<Enemigo> hastaSalirDePantalla = new HastaCondicion<>(bb, escaparAbajo, pasoLaPantalla, true);
        ArrivePosicion<Enemigo> formarse = new ArrivePosicion<>(bb, new Vector2(600,600));
        MirarA<Enemigo> alinear = new MirarA<>(bb);


        Secuencia<Enemigo> secuencia = new Secuencia<>(bb);
        Selector<Enemigo> selector = new Selector<>(bb);
        ///selector.addPrimeraTarea(hastaCondicionKamikaze);
       // selector.addUltimaTarea(hastaSalirDePantalla);
       // selector.addUltimaTarea(formarse);
        secuencia.addPrimeraTarea(alinear);
        secuencia.addUltimaTarea(selector);

        return secuencia;

    }
}
