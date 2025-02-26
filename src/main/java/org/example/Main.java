package org.example;

import AbstractClass.MealAbstract;
import Class.*;
import Enum.*;
import Exaption.*;

import static Enum.DishesEnum.getRandomEnumDish;
import static Enum.MealEnum.getRandomEnumMeal;
import static system.Action.isItReal;
import Record.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

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


        int cafe_type = random.nextInt(2);
        Cafe cafe;
        if (cafe_type == 1) {
            cafe = restaurant;
        } else {
            cafe = cafeteria;
        }

        int planet_type = random.nextInt(2);
        CelestialObject planet = celestialObjects.get(planet_type);

        try {
            isItReal(planet.politicalRegime(), cafe.getName());
            planet.location(planet.name());
            cafe.location(cafe.getName());
        } catch (PlanetExept err) {
            planet.location(planet.name());
            cafe.location(cafe.getName());
            logger.error(err.getMessage());
            logger.info("Идут в другое заведение");
            if (cafe_type == 1) {
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
        Dish d = getRandomEnumDish().getDish();
        d.gettingDirty();

        if (cafe.isFreeFood()) {
            logger.info("Друзья сказали спасибо повару");
            int move = random.nextInt(2);
            if (move == 0) {
                goat.butt();

                dunno.talk(goat.getName());
            } else if (move == 1) {
                bobr.build("bobr");
                dunno.smokingLog();
            }

        } else {
            logger.info("Незнайке принесли счет");
            int price = priceList.get(random.nextInt(priceList.size()));
            if (dunno.getMoney() > price) {
                logger.info("Незнайка расплатился");
                int move = random.nextInt(2);
                if (move == 0) {
                    goat.butt();
                } else if (move == 1) {
                    bobr.build("bobr");
                    dunno.smokingLog();
                }


            } else {
                logger.info("У незнайки не хватило денег");
                dunno.walk("pirson");
            }

        }
    }
}