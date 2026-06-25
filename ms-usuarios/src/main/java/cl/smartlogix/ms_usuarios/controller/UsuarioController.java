package cl.smartlogix.ms_usuarios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.smartlogix.ms_usuarios.model.Usuario;
import cl.smartlogix.ms_usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario crear(
            @RequestBody Usuario usuario) {

        return usuarioService.crear(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtener(
            @PathVariable Long id) {

        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        usuarioService.eliminar(id);
    }
}