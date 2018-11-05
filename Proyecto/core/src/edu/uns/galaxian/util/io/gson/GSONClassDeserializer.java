package edu.uns.galaxian.util.io.gson;

import com.google.gson.*;
import java.lang.reflect.*;

public class GSONClassDeserializer<T> implements JsonDeserializer<T> {

    private static final String CLASS_NAME = "className";

    private Object[] parameters;
    private Class<?>[] parametersTypes;

    public GSONClassDeserializer(final Class<?>[] parametersTypes, final Object[] parameters){
        this.parameters = parameters;
        this.parametersTypes = parametersTypes;
    }

    public GSONClassDeserializer(){
        parameters = new Object[]{};
        parametersTypes = new Class[]{};
    }

    public T deserialize(JsonElement src, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = src.getAsJsonObject();
        if(!json.has(CLASS_NAME)){
            throw new JsonParseException("El archivo JSON no es compatible con este JsonDeserializer");
        }
        try{
            String className = json.get(CLASS_NAME).getAsString();
            Class<?> clase = Class.forName(className);
            return (T) clase.getConstructor(parametersTypes).newInstance(parameters);
        }catch(NoSuchMethodException |SecurityException e){
            throw new JsonParseException("No existe un constructor con los parametros dados.", e);
        }catch(IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new JsonParseException("No se pudo instanciar la clase.", e);
        }catch(ClassCastException | IllegalStateException | NullPointerException e){
            throw new JsonParseException("El archivo JSON proveido no contiene una clase serializada.", e);
        }catch(ClassNotFoundException e){
            throw new JsonParseException("La clase almacenada en el archivo JSON no existe.", e);
        }
    }
}
