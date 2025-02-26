package abstractClasses;

import intarfaces.Entity;

import java.util.Objects;

public abstract class MealAbstract implements Entity {
    protected String name;
    protected int temperature;
    protected int price;

    public MealAbstract(String name, int temperature, int price) {
        setName(name);
        this.temperature = temperature;
        this.price = price;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealAbstract mealAbstract = (MealAbstract) o;

        return price == mealAbstract.price &&
                temperature == mealAbstract.temperature &&
                Objects.equals(name, mealAbstract.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, temperature);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name= " + name +
                ", dirty=" + price +
                "}";
    }
}
