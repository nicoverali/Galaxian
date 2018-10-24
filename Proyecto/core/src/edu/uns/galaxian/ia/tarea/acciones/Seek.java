package edu.uns.galaxian.ia.tarea.acciones;

import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.AutonomoDinamico;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.tarea.Tarea;
import edu.uns.galaxian.ia.utils.SteeringManager;

public class Seek<T extends AutonomoDinamico> implements Tarea<T> {

    private Blackboard<T> blackboard;
    private SteeringManager steering;

    public Seek(Blackboard<T> blackboard){
        this.blackboard = blackboard;
        //this.utils = new Steering();
    }

    public boolean realizar() {
        if(blackboard.getObjetivo() == null){
            return false;
        }
        Autonomo autonomo = blackboard.getAutonomo();
        /*utils.iniciarSteering(autonomo);
        utils.seek(blackboard.getObjetivo().getPosicion(), 50);
        Vector2 velocidadFinal = utils.finalizarSteering();
        autonomo.setVelocidad(velocidadFinal);
        autonomo.setPosicion(autonomo.getPosicion().add(velocidadFinal.scl(Gdx.graphics.getDeltaTime())));*/
        return true;
    }
}
