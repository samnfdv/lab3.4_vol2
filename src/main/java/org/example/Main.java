package org.example;

import classes.*;
import exaptions.*;

import static enums.DishesEnum.getRandomEnumDish;
import static enums.MealEnum.getRandomEnumMeal;
import static system.Action.isItReal;
import records.CelestialObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        Random random = new Random();
        Dunno dunno = new Dunno("Dunno", true, 5, random.nextInt(250, 350));
        Goat goat = new Goat("Goat", true, 5);
        BobrKurva bobr = new BobrKurva("Bobr", true, 5);
        Cafe cafeteria = new Cafe("Cafeteria", true, "8:00-20:00");
        Cafe restaurant = new Cafe("Restaurant", false, "10:00-18:00");

        List<CelestialObject> celestialObjects = new ArrayList<>();
        celestialObjects.add(new CelestialObject("Earth", "planet", 6378, true, "communism"));
        celestialObjects.add(new CelestialObject("Moon", "satellite", 1737, false, "capitalism"));

        List<Integer> priceList = new ArrayList<>(List.of(320, 200, 250));


        int cafeType = random.nextInt(2);
        Cafe cafe;
        if (cafeType == 1) {
            cafe = restaurant;
        } else {
            cafe = cafeteria;
        }

        int planetType = random.nextInt(2);
        CelestialObject planet = celestialObjects.get(planetType);

        try {
            isItReal(planet.politicalRegime(), cafe.getName());
            planet.location(planet.name());
            cafe.location(cafe.getName());
        } catch (PlanetExeption err) {
            planet.location(planet.name());
            cafe.location(cafe.getName());
            LOGGER.error(err.getMessage());
            LOGGER.info("Идут в другое заведение");
            if (cafeType == 1) {
                cafe = cafeteria;
            } else {
                cafe = restaurant;
            }
            cafe.location(cafe.getName());
        }

        dunno.walk(cafe.getName());
        goat.walk(cafe.getName());
        bobr.walk(cafe.getName());


        dunno.eat(getRandomEnumMeal().name(), getRandomEnumMeal().name());
        goat.eat(getRandomEnumMeal().name(), getRandomEnumMeal().name());
        bobr.eat(getRandomEnumMeal().name(), getRandomEnumMeal().name());
        Dish dish = getRandomEnumDish().getDish();
        dish.gettingDirty();

        if (cafe.isFreeFood()) {
            LOGGER.info("Друзья сказали спасибо повару");
            int move = random.nextInt(2);
            if (move == 0) {
                goat.butt();

                dunno.talk(goat.getName());
            } else if (move == 1) {
                bobr.build("bobr");
                dunno.smokingLog();
            }

        } else {
            LOGGER.info("Незнайке принесли счет");
            int price = priceList.get(random.nextInt(priceList.size()));
            if (dunno.getMoney() > price) {
                LOGGER.info("Незнайка расплатился");
                int move = random.nextInt(2);
                if (move == 0) {
                    goat.butt();
                } else if (move == 1) {
                    bobr.build("bobr");
                    dunno.smokingLog();
                }


            } else {
                LOGGER.info("У незнайки не хватило денег");
                dunno.walk("pirson");
            }

        }
    }
}