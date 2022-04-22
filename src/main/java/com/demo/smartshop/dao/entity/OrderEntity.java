package com.demo.smartshop.dao.entity;

import com.demo.smartshop.dao.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "smartshop", catalog = "")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Basic
    @Column(name = "user_id")
    private int userId;

    @Basic
    @Column(name = "shipping_address")
    private String shippingAddress;

    @Basic
    @Column(name = "shipping_date")
    private Date shippingDate;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;


    @Basic
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Basic
    @Column(name = "total_cost")
    private Double totalCost;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private OrderDetailsEntity orderDetailsEntity;
}
