package cl.smartlogix.ms_pedidos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.smartlogix.ms_pedidos.dto.ActualizarEstadoRequest;
import cl.smartlogix.ms_pedidos.dto.PedidoRequest;
import cl.smartlogix.ms_pedidos.model.Pedido;
import cl.smartlogix.ms_pedidos.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(
            @Valid @RequestBody PedidoRequest request) {

        return pedidoService.crearPedido(request);
    }

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPorId(
            @PathVariable Long id) {

        return pedidoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido actualizarEstado(
            @PathVariable Long id,
            @RequestBody ActualizarEstadoRequest request) {

        return pedidoService.actualizarEstado(
                id,
                request.getEstado());
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(
            @PathVariable Long id) {

        pedidoService.eliminarPedido(id);
    }
}