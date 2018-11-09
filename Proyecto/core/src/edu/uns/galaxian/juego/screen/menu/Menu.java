package edu.uns.galaxian.juego.screen.menu;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.ArrayList;
import java.util.List;

public class Menu extends WidgetGroup {

    private VerticalGroup verticalGroup;
    private Color focusColor;
    private int opcionActual;

    /**
     * Crea un nuevo menu con la lista de opciones recibida,
     * separadas por el margen dado.
     * La opcion que en un dado momento tenga el foco tendra
     * el color recibido por parametro
     * @param opciones Lista de opciones
     * @param margen Margen entre cada opcion
     * @param focusColor Color para opciones en foco
     */
    public Menu(List<TextButton> opciones, float margen, Color focusColor){
        this.agregarListeners();
        this.focusColor = focusColor;
        opcionActual = -1;

        verticalGroup = new VerticalGroup();
        verticalGroup.space(margen);

        for(TextButton textButton : opciones){
            verticalGroup.addActor(textButton);
            textButton.addListener(new OpcionesListener(textButton));
        }
        if(!opciones.isEmpty()){
            setOpcionEnFoco(0);
        }
    }

    /**
     * Crea un nuevo menu sin opciones, preparado
     * con el margen y el color de foco dados
     * @param margen Margen entre opciones del menu
     * @param focusColor Color para opciones en foco
     */
    public Menu(float margen, Color focusColor){
        this(new ArrayList<TextButton>(), margen, focusColor);
    }

    /**
     * Agrega una nueva opcion al menu en la posicion dada
     * @param opcion Nueva opcion del menu
     * @param index Posicion de la nueva opcion
     * @throws IndexOutOfBoundsException Si el indice de la nueva posicion es negativo o mayor a la cantidad de opciones
     */
    public void agregarOpcion(TextButton opcion, int index) throws IndexOutOfBoundsException{
        verticalGroup.addActorAt(index, opcion);
        opcion.addListener(new OpcionesListener(opcion));
    }

    /**
     * Agrega una nueva opcion al final del menu
     * @param opcion Nueva opcion
     */
    public void agregarOpcion(TextButton opcion){
        verticalGroup.addActor(opcion);
        opcion.addListener(new OpcionesListener(opcion));
    }

    /**
     * Retorna la cantidad de opciones que posee el menu
     * @return Cantidad de opciones del menu
     */
    public int getCantidadOpciones(){
        return verticalGroup.getChildren().size;
    }

    /**
     * Posiciona al centro del menu en la posicion dada
     * @param x Posicion en X del centro del menu
     * @param y Posicion en Y del centro del menu
     */
    public void setCenter(float x, float y){
        verticalGroup.setPosition(x - verticalGroup.getWidth()/2, y - verticalGroup.getHeight()/2);
    }

    /**
     * Setea en foco la opcion en la posicion recibida
     * @param nuevaOpcionEnFoco Posicion de la nueva opcion en foco
     */
    private void setOpcionEnFoco(int nuevaOpcionEnFoco){
        TextButton nuevo = (TextButton) verticalGroup.getChildren().get(nuevaOpcionEnFoco);
        if(opcionActual != -1) {
            TextButton actual = (TextButton) verticalGroup.getChildren().get(opcionActual);
            actual.getStyle().fontColor = Color.WHITE;
        }
        nuevo.getStyle().fontColor = focusColor;
        opcionActual = nuevaOpcionEnFoco;
    }

    public void act(float delta) {
        verticalGroup.act(delta);
    }

    public void draw(Batch batch, float parentAlpha) {
        verticalGroup.draw(batch, parentAlpha);
    }

    public Actor hit(float x, float y, boolean touchable) {
        Vector2 localCoords = verticalGroup.parentToLocalCoordinates(new Vector2(x, y));
        return verticalGroup.hit(localCoords.x, localCoords.y, false);
    }

    /**
     * Agrega al menu todos los listeners necesarios para su funcionamiento.
     * Se asume que los botones que posee el menu redefinen su accion al ser accionados.
     */
    private void agregarListeners(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode) {
                int cantOpciones = verticalGroup.getChildren().size;
                if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
                    setOpcionEnFoco(opcionActual > 0 ? opcionActual-1 : cantOpciones-1);
                    return true;
                }
                if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
                    setOpcionEnFoco(opcionActual == cantOpciones-1 ? 0 : opcionActual+1);
                    return true;
                }
                if(keycode == Input.Keys.ENTER || keycode == Input.Keys.SPACE){
                    InputEvent pressEvent = new InputEvent();
                    pressEvent.setType(InputEvent.Type.touchDown);
                    pressEvent.setStage(getStage());
                    return verticalGroup.getChildren().get(opcionActual).fire(pressEvent);
                }
                return false;
            }
        });
    }

    /**
     * Listener que se agregara a todas las opciones del menu.
     * Esta pensado para que puedan actuar cuando el mouse pase
     * sobre ellas, seteandole el foco.
     */
    private class OpcionesListener extends InputListener{
        private TextButton opcion;
        public OpcionesListener(TextButton opcion){
            this.opcion = opcion;
        }
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            setOpcionEnFoco(verticalGroup.getChildren().lastIndexOf(opcion, true));
        }
    }
}
