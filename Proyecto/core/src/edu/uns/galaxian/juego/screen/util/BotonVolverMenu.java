package edu.uns.galaxian.juego.screen.util;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import edu.uns.galaxian.juego.Juego;

public class BotonVolverMenu extends TextButton {

    private static final String TEXTO = "Volver Al Menu Menu Principal";
    private Juego juego;

    public BotonVolverMenu(Skin skin, Juego juego){
        super(TEXTO, skin);
        this.juego = juego;
        agregarListener();
    }

    public BotonVolverMenu(TextButtonStyle style, Juego juego) {
        super(TEXTO, style);
        this.juego = juego;
        agregarListener();
    }

    private void agregarListener(){
        this.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                juego.volverAlMenuPrincipal();
                return true;
            }
        });
    }

}
