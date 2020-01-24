package ru.dvilnikov.springinaction.shavacloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.dvilnikov.springinaction.shavacloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
