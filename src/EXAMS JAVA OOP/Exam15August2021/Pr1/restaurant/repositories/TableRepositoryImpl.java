package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> entities;

    public TableRepositoryImpl() {
        this.entities = new ArrayList<>();;
    }

    @Override
    public Table byNumber(int number) {
        return null;
    }

    @Override
    public Collection<Table> getAllEntities() {
        return null;
    }

    @Override
    public void add(Table entity) {

    }
}
