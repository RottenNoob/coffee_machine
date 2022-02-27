package service;

import model.DrinkType;
import model.Order;
import model.SalesData;


import java.util.HashMap;
import java.util.Map;

public class SalesReportService {
    private DrinkTypeAttributesService drinkTypeAttributesService = new DrinkTypeAttributesService();

    public String getReport(SalesDatabase salesDatabase) {
        SalesData salesData = getParsedSalesData(salesDatabase);
        String report = "";
        Map<DrinkType, Integer> drinkSales = salesData.getDrinkSales();
        for (DrinkType drinkType:drinkSales.keySet()) {
            report += drinkType.name() + " :" + drinkSales.get(drinkType) + "; ";
        }
        report += "Total Sale :" + salesData.getTotalSales();
        return report;
    }

    private SalesData getParsedSalesData(SalesDatabase salesDatabase) {
        Map<DrinkType, Integer> drinkSales = new HashMap<>();
        double totalSales = 0.0;
        for (Order order:salesDatabase.getOrderList()) {
            totalSales += drinkTypeAttributesService.getDrinkTypePrice(order.getDrinkType());
            DrinkType drinkType = order.getDrinkType();
            if (drinkSales.containsKey(drinkType)) {
                Integer saleCount = drinkSales.get(drinkType) + 1;
                drinkSales.put(drinkType, saleCount);
            } else {
                drinkSales.put(drinkType, 1);
            }
        }
        SalesData parsedSalesData = new SalesData();
        parsedSalesData.setTotalSales(totalSales);
        parsedSalesData.setDrinkSales(drinkSales);
        return parsedSalesData;
    }

}
