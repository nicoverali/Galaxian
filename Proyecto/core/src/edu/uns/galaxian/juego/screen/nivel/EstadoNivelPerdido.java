package edu.uns.galaxian.juego.screen.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import edu.uns.galaxian.juego.screen.util.BotonSalir;
import edu.uns.galaxian.juego.screen.util.BotonVolverMenu;
import edu.uns.galaxian.juego.screen.util.Menu;
import edu.uns.galaxian.util.enums.Asset;

import java.util.ArrayList;
import java.util.List;

public class EstadoNivelPerdido extends EstadoFinNivel {

    public EstadoNivelPerdido(Nivel nivel, DirectorNivel director) {
        super(nivel, director);
    }

    @Override
    protected List<Label> prepararLabels(int puntaje) {
        List<Label> labels = new ArrayList<>();
        Label.LabelStyle stylePerdiste = new Label.LabelStyle();
        stylePerdiste.font = director.getAssetManager().get(Asset.FONT_24.valor(), BitmapFont.class);
        stylePerdiste.fontColor = Color.YELLOW;
        Label labelPerdiste = new Label("Perdiste el nivel !", stylePerdiste);
        labelPerdiste.setPosition(Gdx.graphics.getWidth()/2 - labelPerdiste.getWidth()/2, 600 - labelPerdiste.getHeight()/2);
        labels.add(labelPerdiste);

        Label.LabelStyle stylePuntaje = new Label.LabelStyle();
        stylePuntaje.font = director.getAssetManager().get(Asset.FONT_16.valor(), BitmapFont.class);
        stylePuntaje.fontColor = Color.WHITE;
        Label labelPuntaje = new Label("Puntaje: " + puntaje, stylePuntaje);
        labelPuntaje.setPosition(Gdx.graphics.getWidth()/2 - labelPuntaje.getWidth()/2, 550 - labelPuntaje.getHeight()/2);
        labels.add(labelPuntaje);

        return labels;
    }

    @Override
    protected Menu prepararMenu() {
        BitmapFont font = director.getAssetManager().get(Asset.FONT_16.valor(), BitmapFont.class);
        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.font = font;
        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.font = font;
        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.font = font;

        TextButton botonReiniciar = new TextButton("Reiniciar Nivel", style1);
        botonReiniciar.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                director.getJuego().iniciarNivelActual();
                return true;
            }
        });

        Menu menu = new Menu(32, Color.YELLOW);
        menu.agregarOpcion(botonReiniciar);
        menu.agregarOpcion(new BotonVolverMenu(style2, director.getJuego()));
        menu.agregarOpcion(new BotonSalir(style3));
        menu.setFocusSound(director.getAssetManager().<Sound>get(Asset.AUDIO_FOCUS.valor()));
        menu.setCenter(Gdx.graphics.getWidth()/2, 350);
        return menu;
    }
}
