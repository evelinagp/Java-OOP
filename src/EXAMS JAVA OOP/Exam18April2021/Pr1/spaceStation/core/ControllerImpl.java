package spaceStation.core;

public class ControllerImpl implements Controller {
    private String type;
    private String astronautName;

    public ControllerImpl(String type, String astronautName) {
        this.type = type;
        this.astronautName = astronautName;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        return null;
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        return null;
    }

    @Override
    public String retireAstronaut(String astronautName) {
        return null;
    }

    @Override
    public String explorePlanet(String planetName) {
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}
