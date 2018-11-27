package edu.uns.galaxian.juego.screen.menuprincipal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.animacion.animator.ValueAnimator;
import edu.uns.galaxian.animacion.animator.ciclos.CicloCircular;
import edu.uns.galaxian.animacion.animator.ciclos.CicloUnico;
import edu.uns.galaxian.animacion.animator.interpolaciones.BezierAnimator;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.enums.Asset;

public class EstadoPressAnyButton implements EstadoAnimacion {

    private static final long DURACION_LOGO = 500;
    private static final long DURACION_PRESS = 700;
    private MenuPrincipal menuPrincipal;
    private BitmapFont font;
    private TextureRegion logo;
    private EntidadBatch batch;
    private Sound startSound;
    private ValueAnimator<Float> animatorLogo;
    private ValueAnimator<Float> animatorPressStart;
    private GlyphLayout glyph;
    private CampoEstrellas estrellas;

    public EstadoPressAnyButton(MenuPrincipal menuPrincipal){
        this.menuPrincipal = menuPrincipal;
        estrellas = menuPrincipal.getEstrellas();
        font = menuPrincipal.getAssetManager().get(Asset.FONT_16.valor());
        logo = menuPrincipal.getLogo();
        batch = new EntidadBatch();
        startSound = menuPrincipal.getAssetManager().get("audio/start.wav");

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
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            startSound.play();
            menuPrincipal.setEstadoAnimacion(new EstadoMenu(menuPrincipal));
        }
    }

}
