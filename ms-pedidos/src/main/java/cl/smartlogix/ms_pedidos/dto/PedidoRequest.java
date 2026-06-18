package cl.smartlogix.ms_pedidos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoRequest {

    @NotBlank
    private String cliente;

    @NotBlank
    private String producto;

    @Min(1)
    private Integer cantidad;
}