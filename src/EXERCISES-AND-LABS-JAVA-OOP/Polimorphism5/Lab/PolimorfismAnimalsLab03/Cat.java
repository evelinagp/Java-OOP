package Polimorphism5.Lab.PolimorfismAnimalsLab03;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + "MEEOW";
    }
}
