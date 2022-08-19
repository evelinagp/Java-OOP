package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BeveragesRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> entities;

    public BeveragesRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return null;
    }

    @Override
    public void add(Beverages entity) {

    }
}
