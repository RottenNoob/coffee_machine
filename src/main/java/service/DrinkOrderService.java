package service;

import model.DrinkType;
import model.Order;

public class DrinkOrderService {
    private DrinkTypeAttributesService drinkTypeAttributesService = new DrinkTypeAttributesService();

    public String takeOrder(Order order) {

        if (order.getMessage() != null) {
            return "M:" + order.getMessage();
        }
        double additionalCashRequired = geCashRequirementMessage(order.getInsertedMoney(), order.getDrinkType());
        if (additionalCashRequired > 0) {
            return "M:Your order requires " + additionalCashRequired + " additional Euros.";
        }
        String instruction = drinkTypeAttributesService.getDrinkTypeInstruction(order.getDrinkType());
        if (order.isExtraHot()) {
            instruction += "h";
        }
        instruction += ":";
        if (order.getSugarQuantity() != null && order.getSugarQuantity() > 0) {
            instruction += String.valueOf(order.getSugarQuantity());
            instruction += ":0";
        } else {
            instruction += ":";
        }


        return instruction;
    }

    private double geCashRequirementMessage(double insertedMoney, DrinkType drinkType) {
        if (insertedMoney < drinkTypeAttributesService.getDrinkTypePrice(drinkType)) {
            return drinkTypeAttributesService.getDrinkTypePrice(drinkType) - insertedMoney;
        }
        return 0.0;
    }
}
