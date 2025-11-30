package ProyectoPOO3.Controlador.Archivos_Excepciones;

public class MiExcepcion extends RuntimeException {
    //Atributos de la clase MiExcepcion
    private int codigo;

    //Métodos de la clase MiExcepcion
    //--Constructor
    public MiExcepcion(int codigo) {
        this.codigo = codigo;
    }
    //--Métodos especiales
    /**
     *Metodo que decodifica el valor de la constante de la interfaz ICodigos y establece el mensaje correspondiente.
     * @return: Retorna un String, según la decoficación.
     */
    public String decodificarError() {
        String mensaje = "";
        switch (codigo) {
            case ICodigos.ERROR_CONTRASENNA_INVALIDA -> mensaje = "InvalidPasswordException";
            case ICodigos.ERROR_USUARIO_INVALIDO -> mensaje = "InvalidUserException";
            case ICodigos.ERROR_CORREO_INVALIDO -> mensaje = "InvalidMailException";
            case ICodigos.ERROR_ARCHIVO_NO_EXISTE -> mensaje = "FileNotFoundException";
            case ICodigos.ERROR_ARCHIVO_WRITE -> mensaje = "FileWriteExcepion";
            case ICodigos.ERROR_CLASE_NO_ENCONTRADA -> mensaje = "ClassNotFoundException";
            case ICodigos.ERROR_ARCHIVO_READ -> mensaje = "FileReadException";
            case ICodigos.ERROR_REGISTRO_NO_EXISTE -> mensaje = "RegistrationNotFoundException";
        }
        return mensaje;
    }
    /**
     * Metodo que retorna el mensaje obtenido del metodo decodificarError
     * @return: Retorna un String, para la excepción.
     */
    @Override
    public String getMessage() {
        return decodificarError();
    }
}
