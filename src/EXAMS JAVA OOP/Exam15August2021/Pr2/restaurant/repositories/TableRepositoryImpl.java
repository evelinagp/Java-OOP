package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> entities;

    public TableRepositoryImpl() {
        this.entities = new ArrayList<>();
        ;
    }

    @Override
    public Table byNumber(int number) {
        return entities.stream().filter(t -> t.getTableNumber() == (number)).findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Table entity) {
        this.entities.add(entity);
    }
}
