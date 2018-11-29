package edu.uns.galaxian.juego.screen.menuprincipal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.screen.util.BotonSalir;
import edu.uns.galaxian.juego.screen.util.Menu;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.enums.Asset;

import java.util.ArrayList;
import java.util.List;

class EstadoMenu implements EstadoAnimacion {

    private MenuPrincipal menuPrincipal;
    private CampoEstrellas estrellas;
    private EntidadBatch batch;
    private BitmapFont font;
    private TextureRegion logo;
    private Stage stage;
    private Menu menu;

    public EstadoMenu(MenuPrincipal menuPrincipal){
        this.menuPrincipal = menuPrincipal;
        estrellas = menuPrincipal.getEstrellas();
        font = menuPrincipal.getAssetManager().get(Asset.FONT_16.valor());
        logo = menuPrincipal.getLogo();
        batch = new EntidadBatch();
        stage = new Stage();
        menu = new Menu(prepararBotones(), 50, Color.YELLOW);
        menu.setCenter(Gdx.graphics.getWidth()/2, 300);
        menu.setFocusSound(menuPrincipal.getAssetManager().<Sound>get(Asset.AUDIO_FOCUS.valor()));
        stage.addActor(menu);
        stage.setKeyboardFocus(menu);
        Gdx.input.setInputProcessor(stage);
    }

    public void accion(float delta) {
        estrellas.draw(delta);
        batch.begin();
        batch.draw(logo, new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 150), 0);
        batch.end();
        stage.act(delta);
        stage.draw();
    }

    private List<TextButton> prepararBotones(){
        ArrayList<TextButton> botones = new ArrayList<>();
        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.font = font;
        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.font = font;
        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.font = font;

        TextButton nuevoJuegoBoton = new TextButton("Nuevo Juego", style1);
        nuevoJuegoBoton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                menuPrincipal.getJuego().iniciarPrimerNivel();
                menu.removerListener();
                return true;
            }
        });
        TextButton salirBoton = new BotonSalir(style2);

        if(menuPrincipal.getJuego().seSuperoElPrimerNivel()){
            TextButton.TextButtonStyle style4 = new TextButton.TextButtonStyle();
            style4.font = font;
            TextButton reanudarJuegoBoton = new TextButton("Reanudar Juego", style4);
            reanudarJuegoBoton.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    super.touchDown(event, x, y, pointer, button);
                    menuPrincipal.getJuego().iniciarNivelAlcanzado();
                    menu.removerListener();
                    return true;
                }
            });
            botones.add(reanudarJuegoBoton);
        }

        botones.add(nuevoJuegoBoton);
        botones.add(salirBoton);
        return botones;
    }

}