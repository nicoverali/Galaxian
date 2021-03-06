package edu.uns.galaxian.escenario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import edu.uns.galaxian.animacion.animator.ValueAnimator;

import java.util.ArrayList;
import java.util.List;

public class CampoEstrellas {

    // Posibles direcciones
    public static final int ADENTRO = 5;
    public static final int AFUERA = 4;
    public static final int ARRIBA = 3;
    public static final int ABAJO = 2;
    public static final int DERECHA = 1;

    private static final int NUMERO_ESTRELLAS = 300;

    private List<Estrella> estrellas;
    private ShapeRenderer renderer;
    private ValueAnimator<Float> animator;
    private float velocidad;
    private Vector3 direccion;

    public CampoEstrellas(int direccion, float velocidad){
        this.direccion = getVectorDireccion(direccion);
        this.velocidad = velocidad;

        // Inicializar renderer
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // Crear estrellas
        estrellas = new ArrayList<>(NUMERO_ESTRELLAS);
        for(int i = 0; i < NUMERO_ESTRELLAS; i++){
            estrellas.add(new Estrella());
        }
    }

    public void setDireccion(int direccion) throws IllegalArgumentException{
        this.direccion = getVectorDireccion(direccion);
    }

    public void setVelocidad(float velocidad) throws IllegalArgumentException{
        if(velocidad < 0) throw new IllegalArgumentException("La velocidad no puede ser negativa.");
        this.velocidad = velocidad;
    }

    public void draw(float delta){
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        renderer.begin();
        renderer.set(ShapeRenderer.ShapeType.Filled);
        for(Estrella estrella : estrellas){
            estrella.mover(direccion, velocidad, delta);
            estrella.dibujar(renderer);
        }
        renderer.end();
    }

    private Vector3 getVectorDireccion(int direccion) throws IllegalArgumentException{
        switch (direccion){
            case ADENTRO: return new Vector3(0, 0, 1);
            case AFUERA: return new Vector3(0, 0, -1);
            case ARRIBA: return new Vector3(0, 1, 0);
            case ABAJO: return new Vector3(0, -1, 0);
            case DERECHA: return new Vector3(1, 0, 0);
            default: throw new IllegalArgumentException("La direccion dada no es valida.");
        }
    }

}