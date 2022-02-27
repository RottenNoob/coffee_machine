package service;

import model.DrinkType;

public class DrinkTypeAttributesService {
    public String getDrinkTypeInstruction(DrinkType drinkType) {
        if (DrinkType.TEA.equals(drinkType)) {
            return "T";
        } else if (DrinkType.CHOCOLATE.equals(drinkType)) {
            return "H";
        } else if (DrinkType.COFFEE.equals(drinkType)) {
            return "C";
        }
        return null;
    }
}
