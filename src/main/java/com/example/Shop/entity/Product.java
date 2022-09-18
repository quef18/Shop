package com.example.Shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@ToString
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "product_size")
    private String size;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_img")
    private String img;

    public String getPrice() {
        return String.format("%.3f", this.price) + "đ";
    }

    public Double getPriceDouble() {
        return this.price;
    }

    public Integer getCategory() {
        return this.category.getId();
    }

    public String getCategoryName() {
        return this.category.getName();
    }

    public String getSize() {
        return size;
    }
}
