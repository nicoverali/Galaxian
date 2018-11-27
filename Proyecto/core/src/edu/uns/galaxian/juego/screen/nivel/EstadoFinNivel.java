package edu.uns.galaxian.juego.screen.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.screen.util.Menu;

import java.util.List;

abstract class EstadoFinNivel implements EstadoAnimacion {

    protected DirectorNivel director;
    private CampoEstrellas estrellas;
    private Stage stage;

    public EstadoFinNivel(Nivel nivel, DirectorNivel director){
        this.director = director;
        estrellas = nivel.getCampoEstrellas();
        stage = new Stage();
        List<Label> labels = prepararLabels(nivel.getJugador().getPuntaje());
        for(Label label : labels){
            stage.addActor(label);
        }
        Menu menu = prepararMenu();
        stage.addActor(menu);
        stage.setKeyboardFocus(menu);
        Gdx.input.setInputProcessor(stage);
    }

    public void accion(float delta) {
        estrellas.draw(delta);
        stage.act(delta);
        stage.draw();
    }

    /**
     * Retorna una lista de labels para mostrar en pantalla
     * @param puntaje Puntaje final del nivel
     * @return Lista de labels para mostrar
     */
    protected abstract List<Label> prepararLabels(int puntaje);

    /**
     * Retorna el menu que se debe mostrar al finalizar el nivel
     * @return Menu al finalizar el nivel
     */
    protected abstract Menu prepararMenu();

}
