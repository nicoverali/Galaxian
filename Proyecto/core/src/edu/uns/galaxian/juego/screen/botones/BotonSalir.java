package edu.uns.galaxian.juego.screen.botones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BotonSalir extends TextButton {
    private static final String TEXTO = "Salir";

    public BotonSalir(Skin skin){
        super(TEXTO, skin);
        agregarListener();
    }

    public BotonSalir(TextButtonStyle style) {
        super(TEXTO, style);
        agregarListener();
    }

    private void agregarListener(){
        this.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });
    }
}
