package model;

public class Order {
    private DrinkType drinkType;

    private Integer sugarQuantity;

    private String message;

    private double insertedMoney;

    private boolean isExtraHot = false;

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Integer getSugarQuantity() {
        return sugarQuantity;
    }

    public void setSugarQuantity(Integer sugarQuantity) {
        this.sugarQuantity = sugarQuantity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public boolean isExtraHot() {
        return isExtraHot;
    }

    public void setExtraHot(boolean extraHot) {
        isExtraHot = extraHot;
    }
}
