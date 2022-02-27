package service;


import model.DrinkType;
import model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrinkOrderServiceTest {


    private DrinkOrderService drinkOrderService = new DrinkOrderService();

    @Test
    void should_get_tea_with_sugar_given_enough_money() {
        Order givenOrder = getTeaWithSugarOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("T:1:0", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_chocolate_without_sugar_given_enough_money() {
        Order givenOrder = getChocolateWithoutSugarOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("H::", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_coffee_with_two_sugars_given_enough_money() {
        Order givenOrder = getCoffeeWithTwoSugarsOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("C:2:0", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_chocolate_with_three_sugars_given_enough_money() {
        Order givenOrder = getChocolateWithThreeSugarsOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("H:3:0", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_message_requiring_additional_money_given_order_without_enough_money() {
        Order givenOrder = getChocolateWithThreeSugarsOrder();
        givenOrder.setInsertedMoney(0.3);
        Assertions.assertEquals("M:Your order requires 0.2 additional Euros.", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_hello_message() {
        Assertions.assertEquals("M:Hello", drinkOrderService.takeOrder(getHelloMessageOrder()));
    }

    private Order getTeaWithSugarOrder() {
        Order teaOrder = new Order();
        teaOrder.setDrinkType(DrinkType.TEA);
        teaOrder.setSugarQuantity(1);
        return teaOrder;
    }

    private Order getChocolateWithoutSugarOrder() {
        Order chocolateOrder = new Order();
        chocolateOrder.setDrinkType(DrinkType.CHOCOLATE);
        return chocolateOrder;
    }

    private Order getCoffeeWithTwoSugarsOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.COFFEE);
        coffeeOrder.setSugarQuantity(2);
        return coffeeOrder;
    }

    private Order getChocolateWithThreeSugarsOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.CHOCOLATE);
        coffeeOrder.setSugarQuantity(3);
        return coffeeOrder;
    }

    private Order getHelloMessageOrder() {
        Order messageOrder = new Order();
        messageOrder.setMessage("Hello");
        return messageOrder;
    }

}