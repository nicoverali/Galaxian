package edu.uns.galaxian.juego.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.EstadoAnimacion;
import edu.uns.galaxian.util.animator.BezierAnimator;
import edu.uns.galaxian.util.animator.ValueAnimator;
import sun.font.TrueTypeFont;

public class Principal extends ScreenAdapter {

    private static final float VELOCIDAD_INICIAL = 3000;

    private Juego juego;
    private CampoEstrellas estrellas;
    private Texture logo;
    private BitmapFont font;
    private EstadoAnimacion estado;

    public Principal(Juego juego){
        this.juego = juego;
        estrellas = new CampoEstrellas(CampoEstrellas.AFUERA, VELOCIDAD_INICIAL);
        logo = new Texture(Gdx.files.internal("menu/logo.png"));
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 28;
        font = gen.generateFont(param);
        estado = new EstadoIntroduccion();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        estado.accion(delta);
    }

    private class EstadoIntroduccion implements EstadoAnimacion {
        private static final float VELOCIDAD_FINAL = 400;
        private static final int DURACION = 3000;
        private ValueAnimator<Float> animator;

        public EstadoIntroduccion(){
            animator = new BezierAnimator<>();
            animator.iniciarAnimacion(VELOCIDAD_INICIAL, VELOCIDAD_FINAL, DURACION);
        }

        public void accion(float delta) {
            if(animator.animacionFinalizada()){
                estado = new EstadoIntermedio();
            }
            else{
                estrellas.setVelocidad(animator.getValorActualFloat());
                estrellas.draw(delta);
            }
        }
    }
    private class EstadoIntermedio implements EstadoAnimacion{
        private static final long DURACION = 500;
        private EntidadBatch batch;
        private ValueAnimator<Float> animator;
        public EstadoIntermedio(){
            batch = new EntidadBatch();
            animator = new BezierAnimator<>();
            animator.iniciarAnimacion(0f, 1f, DURACION);
        }

        public void accion(float delta) {
            estrellas.draw(delta);
            Color c = batch.getColor();
            batch.setColor(c.r, c.g, c.b, animator.getValorActualFloat());
            batch.begin();
            font.draw(batch, "Press start", Gdx.graphics.getWidth()/2-200, Gdx.graphics.getHeight() - 300);
            batch.draw(logo, new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 150), 0);
            batch.end();
        }
    }
    private class EstadoMenu implements EstadoAnimacion{
        public void accion(float delta) {

        }
    }
}

