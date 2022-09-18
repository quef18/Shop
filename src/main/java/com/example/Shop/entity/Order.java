package com.example.Shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "order_detail")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "type")
    private String type;
}
