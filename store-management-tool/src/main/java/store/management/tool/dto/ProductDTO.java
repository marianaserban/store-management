package store.management.tool.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name may not be blank!")
    private String name;

    private String description;

    @Positive(message = "Product price must be greater than 0!")
    private double price;

    @Min(value = 0, message = "Product quantity must be greater than or equal to 0!")
    private int quantity;
}
