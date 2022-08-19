package PolimorphismWildFarmEx03;

public class Zebra extends Mammal {
    protected Zebra(String animalType, String animalName,  double animalWeight, String livingRegion) {
        super(animalType, animalName,  animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
