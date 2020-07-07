public class Topping extends Ingredient implements Calories {
    private String toppingType;
    private double modifier;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Cheese":
                this.modifier = 1.1;
                this.toppingType = toppingType;
                break;
            case "Meat":
                this.modifier = 1.2;
                this.toppingType = toppingType;
                break;
            case "Veggies":
                this.modifier = 0.8;
                this.toppingType = toppingType;
                break;
            case "Sauce":
                this.modifier = 0.9;
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.
                        format("Cannot place %s on top of your pizza.", toppingType));
        }


    }

    @Override
    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.
                    format("%s weight should be in the range [1..50].", this.getToppingType()));
        }
        super.setWeight(weight);
    }

    @Override
    public double calculateCalories() {
        return 2 * this.getWeight() * this.modifier;
    }
}
