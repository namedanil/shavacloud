package ru.dvilnikov.springinaction.shavacloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dvilnikov.springinaction.shavacloud.Ingredient;
import ru.dvilnikov.springinaction.shavacloud.Ingredient.Type;
import ru.dvilnikov.springinaction.shavacloud.Shava;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignShavaController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("FLPT", "Flour Pita", Type.WRAP),
                new Ingredient("CHPT", "Cheese Pita", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("PORK", "Pork", Type.PROTEIN),
                new Ingredient("CHCK", "Chicken", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("CBBG", "Cabbage", Type.VEGGIES),
                new Ingredient("ONIO", "Onion", Type.VEGGIES),
                new Ingredient("PCKL", "Pickle", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE),
                new Ingredient("GRLC", "Garlic Sauce", Type.SAUCE)
        );
        Type[] types = Type.values();
        Arrays.stream(types).forEach(type -> model.addAttribute(type.toString().toLowerCase(),
                ingredients.stream()
                        .filter(ingredient -> ingredient.getType().equals(type))
                        .collect(Collectors.toList())));
        model.addAttribute("design", new Shava());
        return "design";
    }
}
