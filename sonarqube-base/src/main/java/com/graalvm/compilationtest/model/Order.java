
package com.graalvm.compilationtest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {
    @Id
    private Long id;
    private int quantity;

    public Order() {}

    public Order(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public int getQuantity() { return quantity; }
    public void setId(Long id) { this.id = id; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}