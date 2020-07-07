public class Dough extends Ingredient implements Calories {
    private String flourType;
    private String bakingTechnique;
    private double flourModifier;
    private double bakingModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                this.flourModifier = 1.5;
                this.flourType = flourType;
                break;
            case "Wholegrain":
                this.flourModifier = 1.0;
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingModifier = 0.9;
                this.bakingTechnique = bakingTechnique;
                break;
            case "Chewy":
                this.bakingModifier = 1.1;
                this.bakingTechnique = bakingTechnique;
                break;
            case "Homemade":
                this.bakingModifier = 1.0;
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }


    @Override
    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

       super.setWeight(weight);
    }

    @Override
    public double calculateCalories() {
        return 2 * this.getWeight() * this.bakingModifier * this.flourModifier;
    }
}
