package com.projeto.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId //embutindo chave composta
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        this.id.setOrderEntity(order);
        this.id.setProductEntity(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemPK getId() { return id; }
    public void setId(OrderItemPK id) { this.id = id; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public OrderEntity getOrderEntity() { return id.getOrderEntity(); }
    public void setOrderEntity(OrderEntity order) { id.setOrderEntity(order); }

    public ProductEntity getProductEntity() { return id.getProductEntity(); }
    public void setProductEntity(ProductEntity product) { id.setProductEntity(product); }
}
