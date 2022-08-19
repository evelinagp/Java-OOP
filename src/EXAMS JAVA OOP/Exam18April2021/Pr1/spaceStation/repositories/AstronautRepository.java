package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;


public class AstronautRepository<T extends Astronaut> implements Repository<T> {

    private Collection<T> astronauts;


    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.astronauts;
    }

    @Override
    public void add(T astronaut) {
//        if (astronaut == null) {
//            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
//        }
        astronauts.add(astronaut);
    }


    @Override
    public boolean remove(T astronaut) {
        return astronauts.remove(astronaut);
//        if (astronauts.contains(astronaut)) {
//            astronauts.remove(astronaut);
//            return true;
//        }
//        return false;
//    }
    }

    @Override
    public T findByName(String name) {
        return astronauts.stream().filter(d -> d.getClass().getSimpleName().equals(name)).findFirst().orElse(null);
    }
}
