package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.DTOs.OrderItemDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.OrderItem;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import com.projeto.ecommerce.repositories.OrderItemRepository;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.ProductRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    // chama repositório
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional //salvar pedido e itens
    public OrderDTO create(OrderDTO dto) {
        OrderEntity order = new OrderEntity();
        order.setMoment(LocalDate.now());
        order.setStatus(StatusDoPedido.AWAITING_PAYMENT);

        // busca o cliente
        UserEntity client = userRepository.findById(dto.getClient())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        order.setClient(client);

        // salva o pedido
        order = orderRepository.save(order);

        Set<OrderItem> orderItems = new HashSet<>();

        if (dto.getItems() != null) {
            for (OrderItemDTO itemDto : dto.getItems()) {

                // busca o produto no banco e pega o preço
                ProductEntity product = productRepository.findById(itemDto.getProductId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                OrderItem orderItem = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());

                orderItems.add(orderItem);
            }
        }

        // salva os itens na tabela tb_order_item
        orderItemRepository.saveAll(orderItems);

        order.setItems(orderItems);

        return new OrderDTO(order);
    }
}