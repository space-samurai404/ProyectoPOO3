package com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Usuario;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {
    //Atributos de la clase GestorArchivos
    private ArrayList<Usuario> listaUsuarios;
    //Métodos de la clase GestorArchivos
    //--Constructor-setter y getter
    public GestorArchivos() {}
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    //--Métodos especiales
    /**
     * Metodo que guarda toda la información de los usuarios en archivos binarios
     * @param nombreArchivo: Atributo String que representa el nombre del archivo.
     * @param listaUsuarios: Atributo tipo ArrayList<Usuario> que representa toda la información de los usuarios.
     * @return: Retorna un atributo int, que representa un codigo de éxito de la interfaz ICodigos.
     * @throws MiExcepcion
     */
    public int guardarUsuarios(String nombreArchivo) throws MiExcepcion {
        FileOutputStream archivoEscritura = null;
        ObjectOutputStream manejadorEscritura = null;
        try {
            archivoEscritura = new FileOutputStream(nombreArchivo);
            manejadorEscritura = new ObjectOutputStream(archivoEscritura);
            manejadorEscritura.writeObject(listaUsuarios);
            return ICodigos.EXITO;
        }
        catch (FileNotFoundException e) {
            throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_NO_EXISTE);
        } catch (IOException e) {
            throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_WRITE);
        } finally {
            try {
                if (manejadorEscritura != null) {
                    manejadorEscritura.flush();
                    manejadorEscritura.close();
                    archivoEscritura.close();
                }
            } catch (IOException e) {
                throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_WRITE);
            }
        }
    }
    /**
     * Metodo que carga toda la información de los usuarios de un archivo binario.
     * @param nombreArchivo: Atributo String que representa el nombre del archivo a cargar.
     * @return: Retorna un atributo tipo int, que representa un codigo de éxito de la interfaz ICodigos.
     * @throws MiExcepcion
     */
    public int cargarUsuarios(String nombreArchivo) throws MiExcepcion {
        FileInputStream archivoLectura = null;
        ObjectInputStream manejadorLectura = null;
        try {
            archivoLectura = new FileInputStream(nombreArchivo);
            manejadorLectura = new ObjectInputStream(archivoLectura);
            listaUsuarios = (ArrayList<Usuario>) manejadorLectura.readObject();

            return ICodigos.EXITO;
        }
        catch (FileNotFoundException e) {
            throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_NO_EXISTE);
        } catch (ClassNotFoundException e) {
            throw new MiExcepcion(ICodigos.ERROR_CLASE_NO_ENCONTRADA);
        } catch (IOException e) {
            throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_READ);
        } finally {
            try {
                if (manejadorLectura != null) {
                    manejadorLectura.close();
                }
                if (archivoLectura != null) {
                    archivoLectura.close();
                }
            } catch (IOException e) {
                throw new MiExcepcion(ICodigos.ERROR_ARCHIVO_READ);
            }
        }
    }

}
