package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;

import java.time.LocalDate;
import java.util.UUID;

public class OrderDTO {

    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    private UUID client;

    public OrderDTO(UUID id, LocalDate moment, StatusDoPedido status, UUID client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public OrderDTO(){}

    public OrderDTO(OrderEntity order) {

    }
}


