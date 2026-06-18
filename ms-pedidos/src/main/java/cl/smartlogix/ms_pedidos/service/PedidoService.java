package cl.smartlogix.ms_pedidos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.smartlogix.ms_pedidos.dto.PedidoRequest;
import cl.smartlogix.ms_pedidos.exception.PedidoNotFoundException;
import cl.smartlogix.ms_pedidos.model.Pedido;
import cl.smartlogix.ms_pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido crearPedido(PedidoRequest request) {

        Pedido pedido = Pedido.builder()
                .cliente(request.getCliente())
                .producto(request.getProducto())
                .cantidad(request.getCantidad())
                .estado("PENDIENTE")
                .fechaCreacion(LocalDateTime.now())
                .build();

        return repository.save(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new PedidoNotFoundException(id));
    }

    public Pedido actualizarEstado(Long id, String estado) {

        Pedido pedido = repository.findById(id)
                .orElseThrow(() ->
                        new PedidoNotFoundException(id));

        pedido.setEstado(estado);

        return repository.save(pedido);
    }

    public void eliminarPedido(Long id) {

        Pedido pedido = repository.findById(id)
                .orElseThrow(() ->
                        new PedidoNotFoundException(id));

        repository.delete(pedido);
    }
}