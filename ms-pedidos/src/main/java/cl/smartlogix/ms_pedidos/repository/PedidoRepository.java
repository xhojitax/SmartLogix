package cl.smartlogix.ms_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.smartlogix.ms_pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
