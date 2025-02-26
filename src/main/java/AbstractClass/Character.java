package AbstractClass;


import Intarface.AliveEntity;

import java.util.Objects;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public abstract class Character implements AliveEntity {
    protected String name;
    protected boolean alive;
    protected double weight;

    private static final Logger logger = LogManager.getLogger(Character.class);


    public Character(String name, boolean alive, double weight){
        setName(name);
        this.alive = alive;
        setWeight(weight, name);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public double getWeight() {
        return  weight;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setWeight(double weight, String name) {
        if (weight <= 0) {
            this.alive = false;
            logger.error("Из-за слишком маленького веса помер {}", name);
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return alive == character.alive &&
                weight == character.weight &&
                name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, alive, weight);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name=" + name  +
                ", alive=" + alive +
                ", weight=" + weight +
                '}';
    }


}
