package store.management.tool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    @NotBlank(message = "Name may not be blank!")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @Positive(message = "Price must be greater than 0!")
    private double price;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0!")
    private int quantity;
}
