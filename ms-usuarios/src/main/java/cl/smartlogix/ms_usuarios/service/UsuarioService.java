package cl.smartlogix.ms_usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.smartlogix.ms_usuarios.exception.UsuarioNotFoundException;
import cl.smartlogix.ms_usuarios.model.Usuario;
import cl.smartlogix.ms_usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new UsuarioNotFoundException(id));
    }

    public Usuario actualizar(Long id, Usuario datos) {

        Usuario usuario = obtenerPorId(id);

        usuario.setNombre(datos.getNombre());
        usuario.setEmail(datos.getEmail());
        usuario.setPassword(datos.getPassword());
        usuario.setRol(datos.getRol());

        return repository.save(usuario);
    }

    public void eliminar(Long id) {

        Usuario usuario = obtenerPorId(id);

        repository.delete(usuario);
    }
}