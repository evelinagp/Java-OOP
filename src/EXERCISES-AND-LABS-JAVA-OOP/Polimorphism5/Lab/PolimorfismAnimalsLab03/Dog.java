package Polimorphism5.Lab.PolimorfismAnimalsLab03;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + "DJAAF";
    }
}
