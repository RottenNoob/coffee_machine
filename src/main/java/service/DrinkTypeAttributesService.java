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

    public double getDrinkTypePrice(DrinkType drinkType) {
        if (DrinkType.TEA.equals(drinkType)) {
            return 0.4;
        } else if (DrinkType.CHOCOLATE.equals(drinkType)) {
            return 0.5;
        } else if (DrinkType.COFFEE.equals(drinkType)) {
            return 0.6;
        }
        return 0.0;
    }
}
