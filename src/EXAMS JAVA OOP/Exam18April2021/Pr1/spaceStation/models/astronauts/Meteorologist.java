package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{
    private final static int  INITIAL_OXYGEN = 90;
    private final static int  DECREASE_OXYGEN = 10;
    public Meteorologist(String name) {
        super(name,INITIAL_OXYGEN );
        setOxygen(INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double newOxygen = INITIAL_OXYGEN - DECREASE_OXYGEN;
        setOxygen(newOxygen);
    }
}
