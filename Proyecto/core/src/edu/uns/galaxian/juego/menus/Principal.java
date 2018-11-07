package edu.uns.galaxian.juego.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.animacion.animator.ciclos.CicloCircular;
import edu.uns.galaxian.animacion.animator.ciclos.CicloUnico;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.animacion.animator.interpolaciones.BezierAnimator;
import edu.uns.galaxian.animacion.animator.ValueAnimator;

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
        estado = new EstadoIntroduccion();

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 16;
        font = gen.generateFont(param);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        estado.accion(delta);
    }

    // Clases internas de estado

    private class EstadoIntroduccion implements EstadoAnimacion {
        private static final float VELOCIDAD_FINAL = 400;
        private static final int DURACION = 3000;
        private ValueAnimator<Float> animator;

        public EstadoIntroduccion(){
            animator = new BezierAnimator<>();
            animator.iniciarAnimacion(VELOCIDAD_INICIAL, VELOCIDAD_FINAL, DURACION, new CicloUnico());
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
        private static final long DURACION_LOGO = 500;
        private static final long DURACION_PRESS = 700;
        private EntidadBatch batch;
        private ValueAnimator<Float> animatorLogo;
        private ValueAnimator<Float> animatorPressStart;
        private GlyphLayout glyph;
        public EstadoIntermedio(){
            batch = new EntidadBatch();
            animatorLogo = new BezierAnimator<>();
            animatorPressStart = new BezierAnimator<>();
            glyph = new GlyphLayout(font, "Press any button to start");
            animatorLogo.iniciarAnimacion(0f, 1f, DURACION_LOGO, new CicloUnico());
            animatorPressStart.iniciarAnimacion(0.3f, 1f, DURACION_PRESS, new CicloCircular());
        }

        public void accion(float delta) {
            estrellas.draw(delta);
            batch.begin();
            int mitadPantalla = Gdx.graphics.getWidth()/2;
            int altoPantalla = Gdx.graphics.getHeight();
            batch.draw(glyph, font, new Vector2(mitadPantalla, 100), animatorPressStart.getValorActualFloat());
            batch.setColor(1, 1, 1, animatorLogo.getValorActualFloat());
            batch.draw(logo, new Vector2(mitadPantalla, altoPantalla - 150), 0);
            batch.end();
        }
    }
    private class EstadoMenu implements EstadoAnimacion{
        public void accion(float delta) {

        }
    }
}
