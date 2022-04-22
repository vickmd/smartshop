package com.demo.smartshop.dao.entity;

import com.demo.smartshop.dao.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "smartshop", catalog = "")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "price")
    private double price;

    @Basic
    @Column(name = "image")
    private String image;

    @Basic
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
}
