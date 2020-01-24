package ru.dvilnikov.springinaction.shavacloud;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Shava {
    @Id
    @GeneratedValue
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 5, message = "Не солидное имя. Нужно бы 5 символов...")
    private String name;
    @ManyToMany(targetEntity = Ingredient.class)
    @NotNull(message = "Шава из ничего? Выбери хотя бы 1 ингредиент")
    @Size(min = 1, message = "Шава из ничего? Выбери хотя бы 1 ингредиент")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
