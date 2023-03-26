package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsCollectionHierarchyEx07;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int maxSize = 100;
    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(maxSize);
    }
}
