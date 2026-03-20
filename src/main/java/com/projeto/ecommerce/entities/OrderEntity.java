package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate moment;
    private StatusDoPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserEntity client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // tudo oq acontecer com o pedido, acontece com o pagamento
    private PaymentEntity payment;

    @OneToMany(mappedBy = "id.orderEntity")
    private Set<OrderItem> items = new HashSet<>();

    public List<ProductEntity> getProducts() {
        return items.stream().map(x -> x.getProductEntity()).toList();
    }
}
