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

class EstadoNivelGanado extends EstadoFinNivel {

    public EstadoNivelGanado(Nivel nivel, DirectorNivel director){
        super(nivel, director);
    }

    protected List<Label> prepararLabels(int puntaje){
        List<Label> labels = new ArrayList<>();
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = director.getAssetManager().get(Asset.FONT_24.valor(), BitmapFont.class);
        style.fontColor = Color.YELLOW;
        Label labelGanaste = new Label("Ganaste el nivel !", style);
        labelGanaste.setPosition(Gdx.graphics.getWidth()/2 - labelGanaste.getWidth()/2, 600 - labelGanaste.getHeight()/2);
        labels.add(labelGanaste);

        Label.LabelStyle stylePuntaje = new Label.LabelStyle();
        stylePuntaje.font = director.getAssetManager().get(Asset.FONT_16.valor());
        stylePuntaje.fontColor = Color.WHITE;
        Label labelPuntaje = new Label("Puntaje: " + puntaje, stylePuntaje);
        labelPuntaje.setPosition(Gdx.graphics.getWidth()/2 - labelPuntaje.getWidth()/2, 550 - labelPuntaje.getHeight()/2);
        labels.add(labelPuntaje);

        return labels;
    }

    protected Menu prepararMenu(){
        BitmapFont font = director.getAssetManager().get(Asset.FONT_16.valor(), BitmapFont.class);
        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.font = font;
        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.font = font;
        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.font = font;

        TextButton botonSiguiente = new TextButton("Siguiente Nivel", style1);
        botonSiguiente.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                director.getJuego().cargarSiguienteNivel();
                return true;
            }
        });

        Menu menu = new Menu(32, Color.YELLOW);
        menu.agregarOpcion(botonSiguiente);
        menu.agregarOpcion(new BotonVolverMenu(style2, director.getJuego()));
        menu.agregarOpcion(new BotonSalir(style3));
        menu.setFocusSound(director.getAssetManager().<Sound>get(Asset.AUDIO_FOCUS.valor()));
        menu.setCenter(Gdx.graphics.getWidth()/2, 350);
        return menu;
    }
}