package edu.uns.galaxian.juego.screen.menu;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.List;

public class Menu extends Actor {

    private VerticalGroup verticalGroup;
    private List<TextButton> opciones;
    private Color focusColor;
    private int opcionActual;

    public Menu(List<TextButton> opciones, float margen, Color focusColor){
        this.agregarListeners();
        this.opciones = opciones;
        this.focusColor = focusColor;
        opcionActual = 0;
        verticalGroup = new VerticalGroup();
        verticalGroup.space(margen);
        for(TextButton textButton : opciones){
            verticalGroup.addActor(textButton);
        }
        if(!opciones.isEmpty()){
            actualizarFocus(0);
        }
    }

    public void agregarOpcion(TextButton opcion, int index) throws IndexOutOfBoundsException{
        opciones.add(index, opcion);
        verticalGroup.addActorAt(index, opcion);
    }

    public void agregarOpcion(TextButton opcion){
        opciones.add(opcion);
        verticalGroup.addActor(opcion);
    }

    public int getCantidadOpciones(){
        return opciones.size();
    }

    public void setCenter(float x, float y){
        verticalGroup.setPosition(x - verticalGroup.getWidth()/2, y - verticalGroup.getHeight()/2);
    }

    public void actualizar(float delta){
        verticalGroup.act(delta);
    }

    public void draw(Batch batch, float parentAlpha) {
        verticalGroup.draw(batch, parentAlpha);
    }

    private void actualizarFocus(int opcionAnterior){
        opciones.get(opcionAnterior).getStyle().fontColor = Color.WHITE;
        opciones.get(opcionActual).getStyle().fontColor = focusColor;
    }

    private void agregarListeners(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode) {
                System.out.println("Pressss");
                if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
                    if (opcionActual > 0){
                        opcionActual--;
                        actualizarFocus(opcionActual+1);
                        return true;
                    }
                    else {
                        opcionActual = opciones.size()-1;
                        actualizarFocus(0);
                        return true;
                    }
                }
                if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
                    if(opcionActual < opciones.size()-1){
                        opcionActual++;
                        actualizarFocus(opcionActual-1);
                        return true;
                    }
                    else{
                        opcionActual = 0;
                        actualizarFocus(opciones.size()-1);
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
