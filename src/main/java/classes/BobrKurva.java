package classes;

import abstractClasses.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BobrKurva extends Character {
    public BobrKurva(String name, boolean alive, int weight) {
        super(name, alive, weight);
    }
    private static final Logger LOGGER = LogManager.getLogger(BobrKurva.class);

    @Override
    public void walk(String location) {
        LOGGER.info("{} пришел в {}", name, location);
        setWeight(getWeight() - 1, name);
    }


    @Override
    public void eat(String food1, String food2) {
        LOGGER.info("Незнайка съел " + food1 + ',' + food2);
        setWeight(getWeight() + 3, name);
    }

    public void build(String animal) {
        LOGGER.info("Бобер начал строить плотину из столов и стульев между собой и Незнайкой");
    }

    public void smokingLog() {
        LOGGER.info("Сидим с бобром за столом\n" +
                "Вдвоём, курим полено\n" +
                "Давай поговорим, бобёр,\n" +
                "О том, что наболело\n" +
                "Скажи, зачем же между нами плотина,\n" +
                "Скажи, зачем между нами обрыв?\n" +
                "Я обниму твоё пушистое тело\n" +
                "Ну почему бобры так добры?");
    }
}

