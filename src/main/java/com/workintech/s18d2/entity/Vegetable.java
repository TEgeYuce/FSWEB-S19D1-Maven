package com.workintech.s18d2.entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vegetable")
@Builder
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be blank!! ")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Price can't be null!! ")
    @Positive(message = "Price must be positive!! ")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "grownOnTree can't be null!! ")
    @Column(nullable = false)
    private Boolean grownOnTree;


}

