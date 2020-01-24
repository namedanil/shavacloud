package ru.dvilnikov.springinaction.shavacloud.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.dvilnikov.springinaction.shavacloud.Ingredient;
import ru.dvilnikov.springinaction.shavacloud.Ingredient.Type;
import ru.dvilnikov.springinaction.shavacloud.Order;
import ru.dvilnikov.springinaction.shavacloud.Shava;
import ru.dvilnikov.springinaction.shavacloud.data.IngredientRepository;
import ru.dvilnikov.springinaction.shavacloud.data.ShavaRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignShavaController {
    private final IngredientRepository ingredientRepository;
    private final ShavaRepository shavaRepository;

    @Autowired
    public DesignShavaController(IngredientRepository ingredientRepository, ShavaRepository shavaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.shavaRepository = shavaRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        /*List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Пшеничная Тортилья", Type.WRAP),
                new Ingredient("COTO", "Кукурузная Тортилья", Type.WRAP),
                new Ingredient("FLPT", "Пшеничный Лаваш", Type.WRAP),
                new Ingredient("CHPT", "Сырный Лаваш", Type.WRAP),
                new Ingredient("GRBF", "Говядина", Type.PROTEIN),
                new Ingredient("PORK", "Свинина", Type.PROTEIN),
                new Ingredient("CHCK", "Курятина", Type.PROTEIN),
                new Ingredient("TMTO", "Помидорки", Type.VEGGIES),
                new Ingredient("CBBG", "Капуста", Type.VEGGIES),
                new Ingredient("ONIO", "Лук", Type.VEGGIES),
                new Ingredient("PCKL", "Огурцы", Type.VEGGIES),
                new Ingredient("CHED", "Чеддар", Type.CHEESE),
                new Ingredient("JACK", "Монтери-Джек", Type.CHEESE),
                new Ingredient("SLSA", "Сальса", Type.SAUCE),
                new Ingredient("SRCR", "Сырный", Type.SAUCE),
                new Ingredient("GRLC", "Чесночный", Type.SAUCE)
        );*/
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        Type[] types = Type.values();
        Arrays.stream(types).forEach(type -> model.addAttribute(type.toString().toLowerCase(),
                ingredients.stream()
                        .filter(ingredient -> ingredient.getType().equals(type))
                        .collect(Collectors.toList())));
    }

    @ModelAttribute
    public Order order() {
        return new Order();
    }

    @ModelAttribute
    public Shava shava() {
        return new Shava();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Shava shava, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors())
            return "design";
        log.info("Processing design: " + shava);
        Shava savedShava = shavaRepository.save(shava);
        order.addShava(savedShava);
        return "redirect:/orders/current";
    }
}
