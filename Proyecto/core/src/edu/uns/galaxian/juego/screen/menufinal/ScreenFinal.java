package edu.uns.galaxian.juego.screen.menufinal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.screen.util.BotonSalir;
import edu.uns.galaxian.juego.screen.util.BotonVolverMenu;
import edu.uns.galaxian.juego.screen.util.Menu;
import edu.uns.galaxian.util.enums.Asset;

public class ScreenFinal extends ScreenAdapter {

    private Stage stage;
    private CampoEstrellas estrellas;

    public ScreenFinal(Juego juego){
        estrellas = new CampoEstrellas(CampoEstrellas.AFUERA, 400);
        stage = new Stage();
        Menu menu = prepararMenu(juego);
        stage.addActor(menu);
        stage.setKeyboardFocus(menu);
        Gdx.input.setInputProcessor(stage);

        Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.YELLOW;
        style.font = juego.getAssetManager().get(Asset.FONT_24.valor(), BitmapFont.class);
        Label label = new Label("Finalizaste el juego !", style);
        stage.addActor(label);

        menu.setCenter(Gdx.graphics.getWidth()/2, 350);
        label.setPosition(Gdx.graphics.getWidth()/2 - label.getWidth()/2, 600 - label.getHeight()/2);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
        estrellas.draw(delta);
        stage.act(delta);
        stage.draw();
    }

    private Menu prepararMenu(Juego juego){
        Menu menu = new Menu(32, Color.YELLOW);

        TextButtonStyle styleVolverMenu = new TextButtonStyle();
        styleVolverMenu.font = juego.getAssetManager().get(Asset.FONT_16.valor(), BitmapFont.class);
        TextButtonStyle styleSalir = new TextButtonStyle(styleVolverMenu);
        TextButton botonVolverMenu = new BotonVolverMenu(styleVolverMenu, juego);
        TextButton botonSalir = new BotonSalir(styleSalir);

        menu.agregarOpcion(botonVolverMenu);
        menu.agregarOpcion(botonSalir);
        return menu;
    }

}
