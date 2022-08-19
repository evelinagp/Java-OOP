package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private final static int INITIAL_OXYGEN = 70;
    private final static int DECREASE_OXYGEN = 5;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
        setOxygen(INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double newOxygen = INITIAL_OXYGEN - DECREASE_OXYGEN;
        setOxygen(newOxygen);
    }
}
