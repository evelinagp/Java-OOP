package aquarium.entities.aquariums;

import aquarium.entities.fish.BaseFish;

public class SaltwaterAquarium extends BaseFish {
    private static final int CAPACITY = 25;
    protected SaltwaterAquarium(String name, String species, double price) {
        super(name, species, price);
    }
}
