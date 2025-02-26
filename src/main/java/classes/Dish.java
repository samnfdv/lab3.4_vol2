package classes;

import abstractClasses.DishesAbstract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dish extends DishesAbstract {
    public Dish(String name, String material, boolean dirty) {
        super(name, material, dirty);
    }

    private static final Logger LOGGER = LogManager.getLogger(Dish.class);

    @Override
    public void gettingDirty() {
        LOGGER.info("Ребята поели из посуды и она стала грязной");
        dirty = true;
    }
}
