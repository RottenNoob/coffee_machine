package service;

import model.Order;

public class CoffeeOrderService {

        public String takeOrder(Order order) {
            if (order.getMessage() != null) {
                return "M:" + order.getMessage();
            }
            String instruction = "";
            if (order.getDrinkType().equals("tea")) {
                instruction = "T:";
            } else if (order.getDrinkType().equals("chocolate")) {
                instruction = "H:";
            } else if (order.getDrinkType().equals("coffee")) {
                instruction = "C:";
            }
            if (order.getSugarQuantity() != null && order.getSugarQuantity() > 0) {
                instruction += String.valueOf(order.getSugarQuantity());
                instruction += ":0";
            } else {
                instruction += ":";
            }


            return instruction;
        }
}
