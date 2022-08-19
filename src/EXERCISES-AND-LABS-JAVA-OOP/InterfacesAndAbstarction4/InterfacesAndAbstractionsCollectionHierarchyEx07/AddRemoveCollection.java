package InterfacesAndAbstractionsCollectionHierarchyEx07;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return this.items.remove(items.size() - 1);
    }

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return 0;
    }
}
