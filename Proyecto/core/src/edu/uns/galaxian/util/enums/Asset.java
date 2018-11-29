package edu.uns.galaxian.util.enums;

public enum Asset {

    ATLAS_OBSTACULOS("spritesheets/obstaculos.atlas"),
    ATLAS_NAVES("spritesheets/naves.atlas"),
    ATLAS_DISPAROS("spritesheets/disparos.atlas"),
    ATLAS_POWERUP("spritesheets/powerups.atlas"),
    ATLAS_UI("spritesheets/ui.atlas"),
    ATLAS_MISC("spritesheets/misc.atlas"),
    FONT_16("fonts/PressStart2P-16.ttf"),
    FONT_24("fonts/PressStart2P-24.ttf"),
    AUDIO_START("audio/start.wav"),
    AUDIO_FOCUS("audio/menuFocus.wav"),
    MAIN_THEME("audio/mainTheme.mp3");


    private String valor;

    Asset(String valor){
        this.valor = valor;
    }

    public String valor(){
        return valor;
    }

}