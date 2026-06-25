package cl.smartlogix.ms_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.smartlogix.ms_usuarios.model.Usuario;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}