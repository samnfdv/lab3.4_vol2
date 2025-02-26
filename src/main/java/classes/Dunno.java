package classes;
import abstractClasses.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dunno extends Character {
    protected int money;
    public Dunno(String name, boolean alive, int weight, int money) {
        super(name, alive, weight);
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    private static final Logger LOGGER = LogManager.getLogger(Dunno.class);


    @Override
    public void walk(String location) {
        LOGGER.info("Незнайка пришел в {}", location);
        setWeight(getWeight() - 1, name);
    }


    @Override
    public void eat(String food1, String food2) {
        LOGGER.info("Незнайка съел {},{}", food1, food2);
        setWeight(getWeight() + 3, name);
    }

    public void talk(String animal) {
        LOGGER.info("Незнайка начал болтать с {}, но так как это зверь он ему не ответил", animal);
    }

    public void smokingLog(){
        LOGGER.info("Незнайка запел\n"+
                "Сидим с бобром за столом\n" +
                "Вдвоём, курим полено\n" +
                "Давай поговорим, бобёр,\n" +
                "О том, что наболело\n" +
                "Скажи, зачем же между нами плотина,\n" +
                "Скажи, зачем между нами обрыв?\n" +
                "Я обниму твоё пушистое тело\n" +
                "Ну почему бобры так добры?");
    }
}
