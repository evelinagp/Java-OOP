package CounterStriker.repositories;


import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.*;


public class PlayerRepository<T extends Player> implements Repository<T> {
    /*private*/ Collection<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        models.add(model);
    }


    @Override
    public boolean remove(T model) {
        if (models.contains(model)) {
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
//        for (T model : models) {
//            if (model.equals(name)){
//                return model;
//            }
//        }
//        return null;
    }
}

