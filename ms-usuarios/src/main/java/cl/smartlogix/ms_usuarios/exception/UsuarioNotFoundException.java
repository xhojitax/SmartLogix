package cl.smartlogix.ms_usuarios.exception;

public class UsuarioNotFoundException
        extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Usuario no encontrado con id: " + id);
    }
}