package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fishes;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fishes = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (capacity == this.fishes.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        String fishWaterType = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if (!this.getClass().getSimpleName().contains(fishWaterType)) {
            throw new IllegalStateException(WATER_NOT_SUITABLE);
        }
        this.fishes.add(fish);

    }

    @Override
    public void removeFish(Fish fish) {
//        if (fishes.contains(fish)) {
            this.fishes.remove(fish);
        }
//    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        fishes.stream().forEach(fish -> fish.eat());
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        String output = fishes == null || fishes.isEmpty() ? "none" : fishes.stream().map(Fish::getName).collect(Collectors.joining(" "));
        ;
        sb.append(String.format("%s (%s):", name, this.getClass().getSimpleName())).append(System.lineSeparator())
                .append("Fish: " + output).append(System.lineSeparator())
                .append("Decorations: " + decorations.size()).append(System.lineSeparator())
                .append("Comfort: " + calculateComfort()).append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override

    public Collection<Fish> getFish() {
        return fishes;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
