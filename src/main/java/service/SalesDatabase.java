package service;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class SalesDatabase {
    private DrinkTypeAttributesService drinkTypeAttributesService = new DrinkTypeAttributesService();

    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        if (isOrderValid(order)) {
            orderList.add(order);
        }
    }

    private boolean isOrderValid(Order order) {
        return drinkTypeAttributesService.getDrinkTypePrice(order.getDrinkType()) <= order.getInsertedMoney();
    }
}
