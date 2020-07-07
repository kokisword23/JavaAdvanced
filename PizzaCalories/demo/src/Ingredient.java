public abstract class Ingredient {
    private double weight;

    public Ingredient() {
    }

    protected Ingredient(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
