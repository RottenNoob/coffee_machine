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
    void should_get_orange_given_enough_money() {
        Order givenOrder = getOrangeOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("O::", drinkOrderService.takeOrder(givenOrder));
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

    @Test
    void should_get_extra_hot_coffee_without_sugar_given_enough_money() {
        Order givenOrder = getExtraHotCoffeeWithoutSugarOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("Ch::", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_extra_hot_chocolate_with_sugar_given_enough_money() {
        Order givenOrder = getExtraHotChocolateWithSugarOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("Hh:1:0", drinkOrderService.takeOrder(givenOrder));
    }

    @Test
    void should_get_extra_hot_tea_with_two_sugar_given_enough_money() {
        Order givenOrder = getExtraHotTeaWithTwoSugarsOrder();
        givenOrder.setInsertedMoney(0.6);
        Assertions.assertEquals("Th:2:0", drinkOrderService.takeOrder(givenOrder));
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

    private Order getOrangeOrder() {
        Order orangeOrder = new Order();
        orangeOrder.setDrinkType(DrinkType.ORANGE);
        return orangeOrder;
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

    private Order getExtraHotCoffeeWithoutSugarOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.COFFEE);
        coffeeOrder.setSugarQuantity(0);
        coffeeOrder.setExtraHot(true);
        return coffeeOrder;
    }

    private Order getExtraHotChocolateWithSugarOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.CHOCOLATE);
        coffeeOrder.setSugarQuantity(1);
        coffeeOrder.setExtraHot(true);
        return coffeeOrder;
    }

    private Order getExtraHotTeaWithTwoSugarsOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.TEA);
        coffeeOrder.setSugarQuantity(2);
        coffeeOrder.setExtraHot(true);
        return coffeeOrder;
    }

}