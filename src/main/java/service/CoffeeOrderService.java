package service;

import model.DrinkType;
import model.Order;

public class CoffeeOrderService {

        public String takeOrder(Order order) {
            DrinkTypeAttributesService drinkTypeAttributesService = new DrinkTypeAttributesService();
            if (order.getMessage() != null) {
                return "M:" + order.getMessage();
            }
            String instruction = drinkTypeAttributesService.getDrinkTypeInstruction(order.getDrinkType());
            instruction += ":";
            if (order.getSugarQuantity() != null && order.getSugarQuantity() > 0) {
                instruction += String.valueOf(order.getSugarQuantity());
                instruction += ":0";
            } else {
                instruction += ":";
            }


            return instruction;
        }
}
