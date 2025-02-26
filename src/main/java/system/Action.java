package system;

import exaptions.PlanetExeption;


public class Action {

    static public void isItReal(String regime,String cafe ) throws PlanetExeption {
        if((regime.equals("capitalism") & cafe.equals("Cafeteria"))| (regime.equals("communism") & cafe.equals("Restaurant"))){
            throw new PlanetExeption(cafe + " не может быть на этой планете");
        }
    }

}
