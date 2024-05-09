package com.example.foodorderingsystem.datasetup;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.repositories.CuisineRepository;
import com.example.foodorderingsystem.repositories.DessertRepository;
import com.example.foodorderingsystem.repositories.DishRepository;
import com.example.foodorderingsystem.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MenuLoader implements ApplicationListener<ContextRefreshedEvent> {
    private DishRepository dishRepository;
    private DessertRepository dessertRepository;
    private DrinkRepository drinkRepository;
    private CuisineRepository cuisineRepository;

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        createMenuIfNotFound();
    }

    public void createMenuIfNotFound() {
        List<Cuisine> cuisines = getCuisine();
        cuisines.stream()
                .filter(cuisine -> !cuisineRepository.existsByName(cuisine.getName()))
                .forEach(cuisineRepository::save);

        List<Dish> dishes = getDishes();
        dishes.stream()
                .filter(dish -> !dishRepository.existsByName(dish.getName()))
                .forEach(dishRepository::save);

        List<Dessert> desserts = getDesserts();
        desserts.stream()
                .filter(dessert -> !dessertRepository.existsByName(dessert.getName()))
                .forEach(dessertRepository::save);

        List<Drink> drinks = getDrinks();
        drinks.stream()
                .filter(drink -> !drinkRepository.existsByName(drink.getName()))
                .forEach(drinkRepository::save);
    }
    private List<Cuisine> getCuisine(){
        return List.of(
                new Cuisine("Polish"),
                new Cuisine("Mexican"),
                new Cuisine("Italian"));

    }

    private List<Dish> getDishes(){
        return List.of(
                new Dish("Zurek", 3, "", cuisineRepository.findByName("Polish") ),
                new Dish("Bigos", 5, "", cuisineRepository.findByName("Polish")),
                new Dish("Mole", 4, "", cuisineRepository.findByName("Mexican")),
                new Dish("Polenta", 8, "", cuisineRepository.findByName("Italian")),
                new Dish("Perogies", 7, "", cuisineRepository.findByName("Polish")),
                new Dish("Cochinita Pibil", 3, "", cuisineRepository.findByName("Mexican")),
                new Dish("Arancini", 6, "", cuisineRepository.findByName("Italian")),
                new Dish("Flasks", 3, "", cuisineRepository.findByName("Polish")),
                new Dish("Caprese", 4, "", cuisineRepository.findByName("Italian")));
    }

    private List<Dessert> getDesserts(){
        return List.of(
                new Dessert("Charlotte", 2, "", cuisineRepository.findByName("Polish") ),
                new Dessert("Makovets", 5, "", cuisineRepository.findByName("Polish")),
                new Dessert("Churos", 4, "", cuisineRepository.findByName("Mexican")),
                new Dessert("Tiramisu", 5.4, "", cuisineRepository.findByName("Italian")),
                new Dessert("Karpatka", 7, "", cuisineRepository.findByName("Polish")),
                new Dessert("Capirotada", 3, "", cuisineRepository.findByName("Mexican")),
                new Dessert("Caprese cake with vanilla sauce", 1.8, "", cuisineRepository.findByName("Italian")),
                new Dessert("Sernik", 9.2, "", cuisineRepository.findByName("Polish")),
                new Dessert("Mint and chocolate parfait", 4, "", cuisineRepository.findByName("Italian")));

    }

    private List<Drink> getDrinks() {
        return List.of(
                new Drink("lemonade", 2, ""),
                new Drink("wine", 5, ""),
                new Drink("beer", 2.5, ""),
                new Drink("water", 0.5, ""),
                new Drink("cocktail", 7, """
                        Fruit smoothies or smoothies,\s
                        Vegetable smoothies,\s
                        Protein smoothies,\s
                        Alcoholic shakes"""),
                new Drink("mojito", 3, ""),
                new Drink("juice", 1.8, "apple, orange, grape"),
                new Drink("tea", 1.5, "black, fruity, herbal, green"),
                new Drink("coffee", 4, "latte, Americano")

        );
    }

}
