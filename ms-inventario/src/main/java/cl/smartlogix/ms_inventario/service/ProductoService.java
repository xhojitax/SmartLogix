package cl.smartlogix.ms_inventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.smartlogix.ms_inventario.exception.ProductoNotFoundException;
import cl.smartlogix.ms_inventario.model.Producto;
import cl.smartlogix.ms_inventario.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductoNotFoundException(id));
    }

    public Producto actualizar(Long id, Producto datos) {

        Producto producto = obtenerPorId(id);

        producto.setNombre(datos.getNombre());
        producto.setStock(datos.getStock());
        producto.setPrecio(datos.getPrecio());

        return repository.save(producto);
    }

    public void eliminar(Long id) {

        Producto producto = obtenerPorId(id);

        repository.delete(producto);
    }
}