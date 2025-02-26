package classes;

import abstractClasses.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Goat extends Character {
    public Goat(String name, boolean alive, int weight) {
        super(name, alive, weight);
    }
    private static final Logger LOGGER = LogManager.getLogger(Goat.class);

    @Override
    public void walk(String location) {
        LOGGER.info("{} пришел в {}", name, location);
        setWeight(getWeight() - 1, name);
    }


    @Override
    public void eat(String food1, String food2) {
        LOGGER.info("{} съел {},{}", name, food1, food2);
        setWeight(getWeight() + 3, name);
    }

    public void butt() {
        LOGGER.info("Козленок начал бадаться с Незнайкой");
    }

}