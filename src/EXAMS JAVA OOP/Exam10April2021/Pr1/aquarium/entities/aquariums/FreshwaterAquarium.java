package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.Collection;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int CAPACITY = 50;
    protected FreshwaterAquarium(String name, int capacity, Collection<Decoration> decorations, Collection<Fish> fish) {
        super(name, capacity, decorations, fish);
    }
}
