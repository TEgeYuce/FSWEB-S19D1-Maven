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
@Table(name = "fruit")
@Builder
public class Fruit {
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

    @NotNull(message = "Fruit type can't be null!! ")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FruitType fruitType;


}

