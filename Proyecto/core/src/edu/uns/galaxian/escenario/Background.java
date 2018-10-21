package edu.uns.galaxian.escenario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Background {
	
    private static final int NUMERO_ESTRELLAS = 110;
    private static final int VELOCIDAD = 4;
    private List<float[]> estrellas;
    private ShapeRenderer renderer;

    public Background(){
        // Inicializar renderer
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // Crear estrellas
        estrellas = new ArrayList<>(NUMERO_ESTRELLAS);
        int anchoVentana = Gdx.graphics.getWidth();
        int altoVentana = Gdx.graphics.getHeight();
        Random ran = new Random();
        for(int i = 0; i < NUMERO_ESTRELLAS; i++){
            estrellas.add(new float[]{ran.nextInt(anchoVentana) , ran.nextInt(altoVentana)});
        }
    }

    public void draw(){
        int altoVentana = Gdx.graphics.getHeight();
        // Iniciar dibujado
        renderer.begin();
        renderer.set(ShapeRenderer.ShapeType.Filled);

        // Muevo las estrellas y las dibujo
        for(float[] estrella : estrellas){
            // La posicion 1 representa la posicion Y en la pantalla
            estrella[1] = estrella[1] < 0 ? altoVentana : estrella[1]-VELOCIDAD;
            renderer.circle(estrella[0], estrella[1], 1f);
        }

        // Finalizar dibujado
        renderer.end();
    }
}
