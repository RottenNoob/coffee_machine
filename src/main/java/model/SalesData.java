package model;

import java.util.HashMap;
import java.util.Map;

public class SalesData {
    private double totalSales;
    Map<DrinkType, Integer> drinkSales = new HashMap<>();

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public Map<DrinkType, Integer> getDrinkSales() {
        return drinkSales;
    }

    public void setDrinkSales(Map<DrinkType, Integer> drinkSales) {
        this.drinkSales = drinkSales;
    }
}
