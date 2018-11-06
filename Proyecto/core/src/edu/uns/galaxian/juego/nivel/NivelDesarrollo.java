package edu.uns.galaxian.juego.nivel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import edu.uns.galaxian.escenario.CampoEstrellas;

public class NivelDesarrollo extends ApplicationAdapter {

    private CampoEstrellas estrellas;
    private float velocidad = 1000;

    public void create() {
        super.create();
        estrellas = new CampoEstrellas(CampoEstrellas.ADENTRO, velocidad);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void resize(int width, int height) {
    }

    public void render() {
        super.render();
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0.04f, 0.10f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            velocidad += 40;
            estrellas.setVelocidad(velocidad);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(velocidad - 40 > 0){
                velocidad -= 40;
            }else{
                velocidad = 0;
            }
            estrellas.setVelocidad(velocidad);
        }

        estrellas.draw(Gdx.graphics.getDeltaTime());
    }
}
