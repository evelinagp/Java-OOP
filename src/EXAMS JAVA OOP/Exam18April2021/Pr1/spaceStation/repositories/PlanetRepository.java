package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetRepository <T extends Planet> implements Repository<T> {
    private Collection<T> planets;


    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.planets;
    }

    @Override
    public void add(T planet) {
//        if (astronaut == null) {
//            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
//        }
        planets.add(planet);
    }


    @Override
    public boolean remove(T planet) {
        return planets.remove(planet);
//        if (astronauts.contains(astronaut)) {
//            astronauts.remove(astronaut);
//            return true;
//        }
//        return false;
//    }
    }

    @Override
    public T findByName(String name) {
        return planets.stream().filter(d -> d.getClass().getSimpleName().equals(name)).findFirst().orElse(null);
    }
}
