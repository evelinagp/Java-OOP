package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsMilitaryEliteEx06;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int MAX_SIZE = 100;
    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(MAX_SIZE);
    }
}
