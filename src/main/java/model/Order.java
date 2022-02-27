package model;

public class Order {
    private String drinkType;

    private Integer sugarQuantity;

    private String message;

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
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
}
