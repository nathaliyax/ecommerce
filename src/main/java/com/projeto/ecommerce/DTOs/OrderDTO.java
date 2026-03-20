package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    private UUID client;

    private List<OrderItemDTO> items = new ArrayList<>();


    public OrderDTO(OrderEntity order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
            if (order.getClient() != null) {
                this.client = order.getClient().getId();
        }
    }
}


