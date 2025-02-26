package Class;

import AbstractClass.Character;
import AbstractClass.DishesAbstract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dish extends DishesAbstract {
    public Dish(String name, String material, boolean dirty) {
        super(name, material, dirty);
    }

    private static final Logger logger = LogManager.getLogger(Dish.class);

    @Override
    public void gettingDirty() {
        logger.info("Ребята поели из посуды и она стала грязной");
        dirty = true;
    }
}
