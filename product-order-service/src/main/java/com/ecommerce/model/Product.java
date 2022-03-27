package com.ecommerce.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(
        name = "product",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unit",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    String sku;

    @Column(nullable = false, length = 100)
    String name;

    @Column(length = 200)
    String description;

    BigDecimal price;

    boolean active;

    @Column(length = 100)
    String imageUrl;

    @CreationTimestamp
    LocalDateTime dateCreated;

    @UpdateTimestamp
    LocalDateTime lastUpdated;
}
