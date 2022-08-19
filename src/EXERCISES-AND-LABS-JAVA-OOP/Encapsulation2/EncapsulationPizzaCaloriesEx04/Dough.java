package EncapsulationPizzaCaloriesEx04;

//    Dough
public class Dough {
//-	flourType: String
//-	bakingTechnique: String
//-	weight: double
    private String flourType;
    private String bakingTechnique;
    private double weight;

//+ 	Dought (String, String, double)
    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    //-	setWeight(double): void
    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;

    }

    //-	setBakingTechnique(String): void
    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique) && !"Chewy".equals(bakingTechnique) && !"Homemade".equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    //-	setFlourType(String): void
    private void setFlourType(String flourType) {
        if (!"White".equals(flourType) && !"Wholegrain".equals(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    //+	calculateCalories (): double
    public double calculateCalories() {
        return this.weight * 2 * this.getDoughModifiersByFlourType(this.flourType) * this.getDoughModifiersByBakingTechnique(this.bakingTechnique);
    }

    private double getDoughModifiersByBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
            default:
                return 0.0;
        }
    }

    private double getDoughModifiersByFlourType(String flourType) {

        switch (flourType) {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
