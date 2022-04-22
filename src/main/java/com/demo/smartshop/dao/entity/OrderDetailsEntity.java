package com.demo.smartshop.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details", schema = "smartshop", catalog = "")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int id;

    @Basic
    @Column(name = "order_id")
    private int orderId;

    @Basic
    @Column(name = "product_id")
    private int productId;

    @Basic
    @Column(name = "quantity")
    private int quantity;
}
