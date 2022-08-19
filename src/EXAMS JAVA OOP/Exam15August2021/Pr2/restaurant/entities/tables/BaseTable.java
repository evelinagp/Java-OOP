package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.setHealthyFood(new ArrayList<>());
        this.setBeverages(new ArrayList<>());
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.setNumberOfPeople(numberOfPeople);
        this.setIsReservedTable(false);
    }


    private void setIsReservedTable(boolean reserved) {
        this.isReservedTable = reserved;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);

        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setAllPeople(double allPeople) {
        this.allPeople = allPeople;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setBeverages(List<Beverages> beverages) {
        this.beverages = beverages;
    }

    private void setHealthyFood(List<HealthyFood> healthyFood) {
        this.healthyFood = healthyFood;
    }


    public double getPricePerPerson() {
        return this.pricePerPerson;
    }
    @Override
    public  int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.number;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
        setAllPeople(this.pricePerPerson * this.numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sum1 = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double sum2 = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return sum1 + sum2 + this.allPeople;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        setNumberOfPeople(0);
        setAllPeople(0);
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table - %d", getTableNumber())).append(System.lineSeparator());
        sb.append(String.format("Size - %d", getSize())).append(System.lineSeparator());
        sb.append(String.format("Type - %s", getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("All price - %.2f", getPricePerPerson())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
