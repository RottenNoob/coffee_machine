package service;

import model.DrinkType;
import model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalesReportServiceTest {
    private SalesReportService salesReportService = new SalesReportService();

    private final String FINAL_SALE_STRING_REPORT = "Total Sale :";

    @Test
    void should_get_report_given_single_coffee_sale() {
        SalesDatabase salesDatabase = new SalesDatabase();
        Order coffeeOrder = getCoffeeOrder();
        coffeeOrder.setInsertedMoney(0.6);
        salesDatabase.addOrder(coffeeOrder);

        Assertions.assertEquals("COFFEE :1; Total Sale :0.6", salesReportService.getReport(salesDatabase));
    }

    @Test
    void should_get_report_given_single_chocolate_sale() {
        SalesDatabase salesDatabase = new SalesDatabase();
        Order chocolateOrder = getChocolateWithoutSugarOrder();
        chocolateOrder.setInsertedMoney(0.6);
        salesDatabase.addOrder(chocolateOrder);

        Assertions.assertEquals("CHOCOLATE :1; Total Sale :0.5", salesReportService.getReport(salesDatabase));
    }

    @Test
    void should_get_report_given_single_orange_sale() {
        SalesDatabase salesDatabase = new SalesDatabase();
        Order orangeOrder = getOrangeOrder();
        orangeOrder.setInsertedMoney(0.6);
        salesDatabase.addOrder(orangeOrder);

        Assertions.assertEquals("ORANGE :1; Total Sale :0.6", salesReportService.getReport(salesDatabase));
    }

    @Test
    void should_get_report_given_single_tea_sale() {
        SalesDatabase salesDatabase = new SalesDatabase();
        Order teaOrder = getTeaWithSugarOrder();
        teaOrder.setInsertedMoney(0.6);
        salesDatabase.addOrder(teaOrder);

        Assertions.assertEquals("TEA :1; Total Sale :0.4", salesReportService.getReport(salesDatabase));
    }

    @Test
    void should_get_report_given_low_sales() {
        String report = salesReportService.getReport(getSalesDatabaseFromLowSales());
        String expectedTotalSale = "0.9";
        String expectedNumberOfTeaSold = "1";
        String expectedNumberOfCoffeeSold = "0";
        String expectedNumberOfOrangeSold = "0";
        String expectedNumberOfChocolateSold = "1";

        Assertions.assertEquals(expectedTotalSale, getTotalSaleFromPrintedReport(report));
        Assertions.assertEquals(expectedNumberOfTeaSold, getProductSaleFromPrintedReport(report, DrinkType.TEA));
        Assertions.assertEquals(expectedNumberOfCoffeeSold, getProductSaleFromPrintedReport(report, DrinkType.COFFEE));
        Assertions.assertEquals(expectedNumberOfOrangeSold, getProductSaleFromPrintedReport(report, DrinkType.ORANGE));
        Assertions.assertEquals(expectedNumberOfChocolateSold, getProductSaleFromPrintedReport(report, DrinkType.CHOCOLATE));
    }

    @Test
    void should_get_report_given_high_sales() {
        String report = salesReportService.getReport(getSalesDatabaseFromHighSales());
        String expectedTotalSale = "3.1";
        String expectedNumberOfTeaSold = "2";
        String expectedNumberOfCoffeeSold = "0";
        String expectedNumberOfOrangeSold = "3";
        String expectedNumberOfChocolateSold = "1";

        Assertions.assertEquals(expectedTotalSale, getTotalSaleFromPrintedReport(report));
        Assertions.assertEquals(expectedNumberOfTeaSold, getProductSaleFromPrintedReport(report, DrinkType.TEA));
        Assertions.assertEquals(expectedNumberOfCoffeeSold, getProductSaleFromPrintedReport(report, DrinkType.COFFEE));
        Assertions.assertEquals(expectedNumberOfOrangeSold, getProductSaleFromPrintedReport(report, DrinkType.ORANGE));
        Assertions.assertEquals(expectedNumberOfChocolateSold, getProductSaleFromPrintedReport(report, DrinkType.CHOCOLATE));
    }

    private String getTotalSaleFromPrintedReport(String report) {
        if (report != null && report.contains(FINAL_SALE_STRING_REPORT)) {
            return report.substring(report.indexOf(FINAL_SALE_STRING_REPORT) + FINAL_SALE_STRING_REPORT.length());
        }
        return "";
    }

    private String getProductSaleFromPrintedReport(String report, DrinkType drinkType) {
        if (report != null && report.contains(drinkType.name())) {
            String drinkTypeReport = report.substring(report.indexOf(drinkType.name()) + drinkType.name().length() + 2);
            drinkTypeReport = drinkTypeReport.substring(0, drinkTypeReport.indexOf(";"));
            return drinkTypeReport;
        }
        return "0";
    }

    private SalesDatabase getSalesDatabaseFromLowSales() {
        SalesDatabase salesDatabase = new SalesDatabase();

        Order teaOrder = getTeaWithSugarOrder();
        teaOrder.setInsertedMoney(0.4);
        salesDatabase.addOrder(teaOrder);

        Order chocolateOrder = getChocolateWithoutSugarOrder();
        chocolateOrder.setInsertedMoney(0.5);
        salesDatabase.addOrder(chocolateOrder);
        return salesDatabase;
    }

    private SalesDatabase getSalesDatabaseFromHighSales() {
        SalesDatabase salesDatabase = new SalesDatabase();

        Order teaOrder1 = getTeaWithSugarOrder();
        teaOrder1.setInsertedMoney(0.4);
        salesDatabase.addOrder(teaOrder1);

        Order teaOrder2 = getTeaWithSugarOrder();
        teaOrder2.setInsertedMoney(0.7);
        salesDatabase.addOrder(teaOrder2);

        Order chocolateOrder = getChocolateWithoutSugarOrder();
        chocolateOrder.setInsertedMoney(0.5);
        salesDatabase.addOrder(chocolateOrder);

        Order orangeOrder1 = getOrangeOrder();
        orangeOrder1.setInsertedMoney(0.7);
        salesDatabase.addOrder(orangeOrder1);

        Order orangeOrder2 = getOrangeOrder();
        orangeOrder2.setInsertedMoney(0.7);
        salesDatabase.addOrder(orangeOrder2);

        Order orangeOrder3 = getOrangeOrder();
        orangeOrder3.setInsertedMoney(0.7);
        salesDatabase.addOrder(orangeOrder3);

        return salesDatabase;
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

    private Order getCoffeeOrder() {
        Order coffeeOrder = new Order();
        coffeeOrder.setDrinkType(DrinkType.COFFEE);
        return coffeeOrder;
    }
}