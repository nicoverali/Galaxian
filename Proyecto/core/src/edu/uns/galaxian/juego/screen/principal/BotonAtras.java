package edu.uns.galaxian.juego.screen.principal;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import edu.uns.galaxian.animacion.EstadoAnimacion;

public class BotonAtras extends TextButton {

    private Principal principal;
    private EstadoAnimacion estadoAnterior;

    public BotonAtras(Principal principal, EstadoAnimacion anterior, String text, Skin skin){
        super(text, skin);
        this.principal = principal;
        this.estadoAnterior = anterior;
        agregarListener();
    }

    public BotonAtras(Principal principal, EstadoAnimacion anterior, String text, TextButtonStyle style) {
        super(text, style);
        this.principal = principal;
        this.estadoAnterior = anterior;
        agregarListener();
    }

    private void agregarListener(){
        this.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                principal.setEstadoAnimacion(estadoAnterior);
                return true;
            }
        });
    }
}
