package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private final static double INITIAL_OXYGEN = 70;
    private final static double DECREASE_OXYGEN = 5;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double newOxygen = this.getOxygen() - DECREASE_OXYGEN;
        setOxygen(newOxygen);
    }
}
