package system;

import Exaption.PlanetExept;


public class Action {

    static public void isItReal(String regime,String cafe ) throws PlanetExept {
        if((regime.equals("capitalism") & cafe.equals("Cafeteria"))| (regime.equals("communism") & cafe.equals("Restaurant"))){
            throw new PlanetExept(cafe + " не может быть на этой планете");
        }
    }

}
