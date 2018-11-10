package edu.uns.galaxian.ia;

public class TareaNula<T extends Autonomo> extends Tarea<T> {

    public boolean realizar(float delta) {
        return true;
    }
}
