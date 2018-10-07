package edu.uns.galaxian.util.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class IOManager {

    // Holder
    private static class IOManagerHolder{
        private static final IOManager INSTANCE = new IOManager();
    }

    // Pedido de instancia

    /**
     * Retorna una instancia de IOManager
     * @return Instancia de IOManager
     */
    public static IOManager getInstance(){
        return IOManagerHolder.INSTANCE;
    }

    // Metodos

    /**
     * Retorna como String el contenido de un archivo ubicado en la direccion proveida.
     * @param dirRelativa Direccion del archivo
     * @param local Verdadero si el archivo es local, sino es interno
     * @return Contenido del archivo como String
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar leerlo
     */
    public String leerArchivo(String dirRelativa, boolean local) throws IOException {
        FileHandle archivo = local ? Gdx.files.local(dirRelativa) : Gdx.files.internal(dirRelativa);
        if(!archivo.exists()){
            throw new IOException("El archivo no existe.");
        }
        try{
            return archivo.readString("UTF-8");
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un error al intentar leer el archivo.",e);
        }
    }

    /**
     * Retorna como String el contenido de un archivo ubicado en la direccion proveida.
     * @param dirRelativa Direccion del archivo
     * @return Contenido del archivo como String
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar leerlo
     */
    public String leerArchivo(String dirRelativa) throws IOException{
        return leerArchivo(dirRelativa, false);
    }

    /**
     * Retorna como un arreglo de bytes el contenido de un archivo ubicado en la direccion proveida.
     * @param dirRelativa Direccion del archivo
     * @param local Verdadero si el archivo es local, sino es interno
     * @return Contenido del archivo como un arreglo de bytes
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar leerlo
     */
    public byte[] leerArchivoBytes(String dirRelativa, boolean local) throws IOException{
        FileHandle archivo = local ? Gdx.files.local(dirRelativa) : Gdx.files.internal(dirRelativa);
        if(!archivo.exists()){
            throw new IOException("El archivo no existe.");
        }
        try{
            return archivo.readBytes();
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un error al intentar leer el archivo.",e);
        }
    }

    /**
     * Retorna como un arreglo de bytes el contenido de un archivo ubicado en la direccion proveida.
     * @param dirRelativa Direccion del archivo
     * @return Contenido del archivo como un arreglo de bytes
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar leerlo
     */
    public byte[] leerArchivoBytes(String dirRelativa) throws IOException{
        return leerArchivoBytes(dirRelativa, false);
    }

    /**
     * Escribe en memoria y como String el contenido dado en la direccion proveida. Si el parametro anexar es verdadero,
     * entonces en caso de que exista el archivo, se escribira al final del mismo, sino se sobreescribira
     * @param dirRelativa Direccion del archivo a escribir
     * @param contenido Contenido a escribir
     * @param anexar Verdadero si se desea escribir al final del archivo en caso de que ya exista
     * @throws IOException Si no se tiene permisos para escribir en esta direccion o ocurre un problema la intentar hacerlo
     */
    public void escribirArchivoComoString(String dirRelativa, String contenido, boolean anexar) throws IOException{
        FileHandle archivo = Gdx.files.local(dirRelativa);
        try{
            archivo.writeString(contenido, anexar);
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un error al intentar escibir el archivo.", e);
        }
    }

    /**
     * Escribe en memoria y como String el contenido dado en la direccion proveida. Si el parametro anexar es verdadero,
     * entonces en caso de que exista el archivo, se escribira al final del mismo, sino se sobreescribira
     * @param dirRelativa Direccion del archivo a escribir
     * @param contenido Contenido a escribir
     * @param anexar Verdadero si se desea escribir al final del archivo en caso de que ya exista
     * @throws IOException Si no se tiene permisos para escribir en esta direccion o ocurre un problema la intentar hacerlo
     */
    public void escribirArchivoComoString(String dirRelativa, byte[] contenido, boolean anexar) throws IOException{
        escribirArchivoComoString(dirRelativa, new String(contenido), anexar);
    }

    /**
     * Escribe en memoria y como arreglo de bytes el contenido dado en la direccion proveida. Si el parametro anexar es verdadero,
     * entonces en caso de que exista el archivo, se escribira al final del mismo, sino se sobreescribira
     * @param dirRelativa Direccion del archivo a escribir
     * @param contenido Contenido a escribir
     * @param anexar Verdadero si se desea escribir al final del archivo en caso de que ya exista
     * @throws IOException Si no se tiene permisos para escribir en esta direccion o ocurre un problema la intentar hacerlo
     */
    public void escribirArchivoComoBytes(String dirRelativa, String contenido, boolean anexar) throws IOException{
        escribirArchivoComoBytes(dirRelativa, contenido.getBytes("UTF-8"), anexar);
    }

/**
 * Escribe en memoria y como arreglo de bytes el contenido dado en la direccion proveida. Si el parametro anexar es verdadero,
 * entonces en caso de que exista el archivo, se escribira al final del mismo, sino se sobreescribira
 * @param dirRelativa Direccion del archivo a escribir
 * @param contenido Contenido a escribir
 * @param anexar Verdadero si se desea escribir al final del archivo en caso de que ya exista
 * @throws IOException Si no se tiene permisos para escribir en esta direccion o ocurre un problema la intentar hacerlo
 */
    public void escribirArchivoComoBytes(String dirRelativa, byte[] contenido, boolean anexar) throws IOException{
        FileHandle archivo = Gdx.files.local(dirRelativa);
        try{
            archivo.writeBytes(contenido, anexar);
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un error al intentar escibir el archivo.", e);
        }
    }

    /**
     * Marca el arhivo en la direccion dada como oculto.
     * @param dirRelativa Direccion del archivo
     * @param local Verdadero si el archivo es local, sino es interno
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar modificarlo
     */
    public void ocultarArchivo(String dirRelativa, boolean local) throws IOException{
        try{
            Path path = local ? Paths.get(Gdx.files.local(dirRelativa).path()) : Paths.get(Gdx.files.internal(dirRelativa).path());
            if(local){
                Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
            }
        }catch (InvalidPathException pe){
            throw new IOException("El archivo no existe.", pe);
        }catch (IOException | SecurityException e){
            throw new IOException("Ocurrio un error al intentar ocultar el archivo.");
        }
    }

    /**
     * Marca el arhivo en la direccion dada como oculto.
     * @param dirRelativa Direccion del archivo
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar modificarlo
     */
    public void ocultarArchivo(String dirRelativa) throws IOException{
        try{
            Path path = Paths.get(Gdx.files.internal(dirRelativa).path());
            Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        }catch (InvalidPathException pe){
            throw new IOException("El archivo no existe.", pe);
        }catch (IOException | SecurityException e){
            throw new IOException("Ocurrio un error al intentar ocultar el archivo.");
        }
    }

    /**
     * Marca el arhivo en la direccion dada como solo lectura.
     * @param dirRelativa Direccion del archivo
     * @param local Verdadero si el archivo es local, sino es interno
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar modificarlo
     */
    public void marcarSoloLectura(String dirRelativa, boolean local) throws IOException{
        File archivo = local ? new File(Gdx.files.local(dirRelativa).path()) : new File(Gdx.files.internal(dirRelativa).path());
        if(!archivo.exists()){
            throw new IOException("El archivo no existe.");
        }
        if(!archivo.setReadOnly()){
            throw new IOException("Ocurrio un error al intentar marcar el archivo como solo lectura.");
        }
    }

    /**
     * Marca el arhivo en la direccion dada como solo lectura.
     * @param dirRelativa Direccion del archivo
     * @throws IOException Si el archivo no existe o ocurre un problema al intentar modificarlo
     */
    public void marcarSoloLectura(String dirRelativa) throws IOException{
        File archivo = new File(Gdx.files.internal(dirRelativa).path());
        if(!archivo.exists()){
            throw new IOException("El archivo no existe.");
        }
        if(!archivo.setReadOnly()){
            throw new IOException("Ocurrio un error al intentar marcar el archivo como solo lectura.");
        }
    }

    /**
     * Dada una String, se obtiene el hash MD5 de la misma en forma hexadecimal como String.
     * @param contenido Contenido del cual se quiere obtener el hash
     * @return Hash MD5 del contenido representado en hexadecimal y como String
     */
    public String obtenerMD5Hex(String contenido){
        try{
            byte[] data = MessageDigest.getInstance("MD5").digest(contenido.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                stringBuffer.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuffer.toString();
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            System.out.println("Lo imposible se volvio real.");
            return null;
        }
    }

    /**
     * Dado un arreglo de bytes, se obtiene el hash MD5 del mismo en forma hexadecimal como String.
     * @param contenido Contenido del cual se quiere obtener el hash
     * @return Hash MD5 del contenido representado en hexadecimal y como String
     */
    public String obtenerMD5Hex(byte[] contenido){
        try{
            byte[] data = MessageDigest.getInstance("MD5").digest(contenido);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                stringBuffer.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuffer.toString();
        }catch (NoSuchAlgorithmException e){
            System.out.println("Lo imposible se volvio real.");
            return null;
        }
    }

    /**
     * Dada una String, se obtiene el hash MD5 de la misma en forma de arreglo de bytes.
     * @param contenido Contenido del cual se quiere obtener el hash
     * @return Hash MD5 del contenido representado como un arreglo de bytes
     */
    public byte[] obtenerMD5Byte(String contenido){
        try{
            return MessageDigest.getInstance("MD5").digest(contenido.getBytes("UTF-8"));
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            System.out.println("Las vacas vuelan");
            return null;
        }
    }

    /**
     * Dado un arreglo de bytes, se obtiene el hash MD5 del mismo en forma de arreglo de bytes.
     * @param contenido Contenido del cual se quiere obtener el hash
     * @return Hash MD5 del contenido representado como un arreglo de bytes
     */
    public byte[] obtenerMD5Byte(byte[] contenido){
        try{
            return MessageDigest.getInstance("MD5").digest(contenido);
        }catch (NoSuchAlgorithmException e){
            System.out.println("Las vacas vuelan");
            return null;
        }
    }

    /**
     * Dado un archivo escrito en forma de String o bytes, se verifica su integridad con un hash MD5 representado
     * en hexadecimal como String y guardado en un archivo.
     * Para un correcto funcionamiento se espera que ambos archivos hayan sido creados a partir de esta clase,
     * en caso contrario pueden producirse errores.
     * @param dirArchivo Direccion del arhivo del cual se quiere verificar la integridad
     * @param archivoEnBytes Verdadero si el archivo en cuestion esta almacenado en forma de bytes
     * @param dirMD5 Direccion del archivo que contiene que hash MD5
     * @param local Verdadero si los archivos son locales, sino, son internos
     * @return Verdadero si el archivo resulta estar integro, falso en caso contrario
     * @throws IOException Si alguno de los dos archivos no existe o ocurre un problema con la lectura
     */
    public boolean verificarIntegridadConStringMD5(String dirArchivo, boolean archivoEnBytes, String dirMD5, boolean local) throws IOException{
        boolean integro = false;
        try{
            FileHandle archivo = local ? Gdx.files.local(dirArchivo) : Gdx.files.internal(dirArchivo);
            String md5Original = (local ? Gdx.files.local(dirMD5) : Gdx.files.internal(dirMD5)).readString();
            if(archivoEnBytes){
                if(md5Original.equals(obtenerMD5Hex(archivo.readBytes()))){
                    integro = true;
                }
            }
            else if(md5Original.equals(obtenerMD5Hex(archivo.readString("UTF-8")))){
                integro = true;
            }
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un problema al intentar leer los archivos");
        }

        return integro;
    }

    /**
     * Dado un archivo escrito en forma de String o bytes, se verifica su integridad con un hash MD5 representado
     * en hexadecimal como String y guardado en un archivo.
     * Para un correcto funcionamiento se espera que ambos archivos hayan sido creados a partir de esta clase,
     * en caso contrario pueden producirse errores.
     * @param dirArchivo Direccion del arhivo del cual se quiere verificar la integridad
     * @param archivoEnBytes Verdadero si el archivo en cuestion esta almacenado en forma de bytes
     * @param dirMD5 Direccion del archivo que contiene que hash MD5
     * @param local Verdadero si los archivos son locales, sino, son internos
     * @return Verdadero si el archivo resulta estar integro, falso en caso contrario
     * @throws IOException Si alguno de los dos archivos no existe o ocurre un problema con la lectura
     */
    public boolean verificarIntegridadConBytesMD5(String dirArchivo, boolean archivoEnBytes, String dirMD5, boolean local) throws IOException{
        boolean integro = false;
        try {
            FileHandle archivo = local ? Gdx.files.local(dirArchivo) : Gdx.files.internal(dirArchivo);
            byte[] md5Original = (local ? Gdx.files.local(dirMD5) : Gdx.files.internal(dirMD5)).readBytes();
            if (archivoEnBytes) {
                if (Arrays.equals(md5Original, obtenerMD5Byte(archivo.readBytes()))) {
                    integro = true;
                }
            } else if (Arrays.equals(md5Original, obtenerMD5Byte(archivo.readString("UTF-8")))) {
                integro = true;
            }
        }catch (GdxRuntimeException e){
            throw new IOException("Ocurrio un problema al intentar leer los archivos");
        }
        return integro;
    }
}
