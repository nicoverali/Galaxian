package edu.uns.galaxian.util.io.gson;

import com.google.gson.*;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.oleada.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class GSONOleadaDecoratorDeserializer implements JsonDeserializer<Oleada> {

    private static final String CLASS_NAME = "className";
    private Oleada oleadaActual;
    private Controlador controlador;

    public GSONOleadaDecoratorDeserializer(Oleada oleadaPrincipal, Controlador controlador){
        this.controlador = controlador;
        oleadaActual = oleadaPrincipal;
    }

    public Oleada deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if(oleadaActual == null){
            throw new JsonParseException("No se puede deserializar los decorators si no se especifica la Oleada principal.");
        }
        JsonArray decorators = json.getAsJsonArray();
        for(int i = 0; i < decorators.size(); i++){
            String decoratorName = decorators.get(i).getAsJsonObject().get(CLASS_NAME).getAsString();
            try {
                Class<?> clase = Class.forName(decoratorName);
                oleadaActual = (OleadaDecorator) clase.getConstructor(new Class[]{Oleada.class, Controlador.class}).newInstance(new Object[]{oleadaActual, controlador});
            } catch (ClassNotFoundException e) {
                throw new JsonParseException("La clase almacenada en el archivo no existe.");
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                throw new JsonParseException("Error al utilizar el constructior de un OleadaDecorator.");
            }
        }
        return oleadaActual;
    }
}
