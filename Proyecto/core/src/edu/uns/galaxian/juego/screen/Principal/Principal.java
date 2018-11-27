package edu.uns.galaxian.juego.screen.Principal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import edu.uns.galaxian.animacion.animator.ValueAnimator;
import edu.uns.galaxian.animacion.animator.ciclos.CicloUnico;
import edu.uns.galaxian.animacion.animator.interpolaciones.BezierAnimator;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.util.enums.Asset;

public class Principal extends ScreenAdapter {

    static final float VELOCIDAD_INICIAL = 3000;

    private Juego juego;
    private CampoEstrellas estrellas;
    private Texture logo;
    private EstadoAnimacion estado;
    private AssetManager assetManager;
    private Music screenMusic;
    private ValueAnimator<Float> musicAnimator;

    public Principal(Juego juego){
        this.juego = juego;
        assetManager = juego.getAssetManager();
        logo = assetManager.get(Asset.LOGO_TEXTURE.valor());

        estrellas = new CampoEstrellas(CampoEstrellas.AFUERA, VELOCIDAD_INICIAL);
        estado = new EstadoIntroduccion(this);

        screenMusic = assetManager.get(Asset.MAIN_THEME.valor());
        musicAnimator = new BezierAnimator<>();
        musicAnimator.iniciarAnimacion(0f, 0.5f, 3500, new CicloUnico());
        screenMusic.setLooping(true);
        screenMusic.setVolume(musicAnimator.getValorActualFloat());
        screenMusic.play();

        Gdx.input.setInputProcessor(null);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        screenMusic.setVolume(musicAnimator.getValorActualFloat());
        estado.accion(delta);
    }

    /**
     * Cambia el estado actual de la animacion por uno nuevo
     * @param estadoAnimacion Nuevo estado de animacion
     */
    void setEstadoAnimacion(EstadoAnimacion estadoAnimacion){
        estado = estadoAnimacion;
    }

    /**
     * Retorna el juego
     * @return Juego
     */
    Juego getJuego(){
        return juego;
    }

    /**
     * Retorna el logo del juego
     * @return Logo del juego
     */
    Texture getLogo(){
        return logo;
    }

    /**
     * Retorna el campo de estrellas que utiliza la pantalla
     * @return Campo de estrellas
     */
    CampoEstrellas getEstrellas(){
        return estrellas;
    }

    /**
     * Retorna el AssetManager del juego
     * @return AssetManager del juego
     */
    AssetManager getAssetManager(){
        return assetManager;
    }
}
