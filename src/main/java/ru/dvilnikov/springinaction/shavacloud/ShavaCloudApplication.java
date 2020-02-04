package ru.dvilnikov.springinaction.shavacloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dvilnikov.springinaction.shavacloud.data.IngredientRepository;
import ru.dvilnikov.springinaction.shavacloud.data.UserRepository;

@SpringBootApplication
public class ShavaCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShavaCloudApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository, UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ingredientRepository.save(new Ingredient("FLTO", "Пшеничная Тортилья", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("COTO", "Кукурузная Тортилья", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("FLPT", "Пшеничный Лаваш", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("CHPT", "Сырный Лаваш", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("GRBF", "Говядина", Ingredient.Type.PROTEIN));
                ingredientRepository.save(new Ingredient("PORK", "Свинина", Ingredient.Type.PROTEIN));
                ingredientRepository.save(new Ingredient("CHCK", "Курятина", Ingredient.Type.PROTEIN));
                ingredientRepository.save(new Ingredient("TMTO", "Помидорки", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CBBG", "Капуста", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("ONIO", "Лук", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("PCKL", "Огурцы", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CHED", "Чеддар", Ingredient.Type.CHEESE));
                ingredientRepository.save(new Ingredient("JACK", "Монтери-Джек", Ingredient.Type.CHEESE));
                ingredientRepository.save(new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE));
                ingredientRepository.save(new Ingredient("SRCR", "Сырный", Ingredient.Type.SAUCE));
                ingredientRepository.save(new Ingredient("GRLC", "Чесночный", Ingredient.Type.SAUCE));
                userRepository.save(new User("admin", new BCryptPasswordEncoder().encode("admin"),
                        "Админов Админушка Админович", "Админовская 1","Админоград",
                        "+79888086488")); //TODO new BCryptPE() надо заменить на бин из SecurityConfig
            }
        };
    }

}
