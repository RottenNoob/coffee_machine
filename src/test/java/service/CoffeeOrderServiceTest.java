package service;


import model.DrinkType;
import model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoffeeOrderServiceTest {


    private CoffeeOrderService coffeeOrderService = new CoffeeOrderService();

    @Test
    void should_get_tea_with_sugar() {
        Assertions.assertEquals("T:1:0", coffeeOrderService.takeOrder(getTeaWithSugarOrder()));
    }

    @Test
    void should_get_chocolate_without_sugar() {
        Assertions.assertEquals("H::", coffeeOrderService.takeOrder(getChocolateWithoutSugarOrder()));
    }

    @Test
    void should_get_coffee_with_two_sugars() {
        Assertions.assertEquals("C:2:0", coffeeOrderService.takeOrder(getCoffeeWithTwoSugarsOrder()));
    }

    @Test
    void should_get_chocolate_with_three_sugars() {
        Assertions.assertEquals("H:3:0", coffeeOrderService.takeOrder(getChocolateWithThreeSugarsOrder()));
    }

    @Test
    void should_get_hello_message() {
        Assertions.assertEquals("M:Hello", coffeeOrderService.takeOrder(getHelloMessageOrder()));
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