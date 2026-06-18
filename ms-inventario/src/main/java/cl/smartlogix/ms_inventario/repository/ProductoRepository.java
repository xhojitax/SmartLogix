package cl.smartlogix.ms_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.smartlogix.ms_inventario.model.Producto;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {
}